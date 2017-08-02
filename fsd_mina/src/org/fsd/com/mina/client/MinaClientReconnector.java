package org.fsd.com.mina.client;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.MdcInjectionFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.fsd.com.mina.server.ServerCodeFactory;
import org.fsd.com.test.Constant;

/**
 * mina心跳断线重连
 * @Test测试用
 * @ClassName: MInaClientReconnector
 * @Description:
 * @author ken
 * @date 2017年7月25日 下午5:20:09
 */
public class MinaClientReconnector {
	static final Logger LOG = Logger.getLogger(MinaClientReconnector.class);
	private static IoSession session = null;
	private static NioSocketConnector connector = null;

	public static void reconnector() throws InterruptedException {
		connector = new NioSocketConnector(); // 创建连接客户端
		connector.setConnectTimeoutMillis(30000); // 设置连接超时
		// 断线重连回调拦截器
		connector.getFilterChain().addFirst("reconnection", new IoFilterAdapter() {
			@Override
			public void sessionClosed(NextFilter nextFilter, IoSession ioSession) throws Exception {
				for (;;) {
					try {
						Thread.sleep(3000);
						ConnectFuture future = connector.connect();
						future.awaitUninterruptibly();// 等待连接创建成功
						session = future.getSession();// 获取会话
						if (session.isConnected()) {
							LOG.warn("断线重连[" + connector.getDefaultRemoteAddress().getHostName() + ":"
									+ connector.getDefaultRemoteAddress().getPort() + "]成功");
							break;
						}
					} catch (Exception ex) {
						LOG.warn("重连服务器登录失败,3秒再连接一次:" + ex.getMessage());
					}
				}
			}
		});

		connector.getFilterChain().addLast("mdc", new MdcInjectionFilter());
		// 加入解码器
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ServerCodeFactory()));

		connector.getSessionConfig().setReceiveBufferSize(10240); // 设置接收缓冲区的大小
		connector.getSessionConfig().setSendBufferSize(10240);// 设置输出缓冲区的大小

		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30000); // 读写都空闲时间:30秒
		connector.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE, 40000);// 读(接收通道)空闲时间:40秒
		connector.getSessionConfig().setIdleTime(IdleStatus.WRITER_IDLE, 50000);// 写(发送通道)空闲时间:50秒

		// 添加处理器
		connector.setHandler(new ClientHandler());

		connector.setDefaultRemoteAddress(new InetSocketAddress(Constant.IP_ADDR, Constant.PORT));// 设置默认访问地址
		for (;;) {
			try {
				ConnectFuture future = connector.connect();
				// 等待连接创建成功
				future.awaitUninterruptibly();
				// 获取会话
				session = future.getSession();
				LOG.warn("连接服务端" + Constant.IP_ADDR + ":" + Constant.PORT + "[成功]" + ",,时间:"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				break;
			} catch (RuntimeIoException e) {
				System.out.println("连接服务端" + Constant.IP_ADDR + ":" + Constant.PORT + "失败" + ",,时间:"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
						+ ", 连接MSG异常,请检查MSG端口、IP是否正确,MSG服务是否启动,异常内容:" + e.getMessage());
				LOG.warn("连接服务端" + Constant.IP_ADDR + ":" + Constant.PORT + "失败" + ",,时间:"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
						+ ", 连接MSG异常,请检查MSG端口、IP是否正确,MSG服务是否启动,异常内容:" + e.getMessage(), e);
				Thread.sleep(5000);// 连接失败后,重连10次,间隔30s
			}
		}
	}
}
