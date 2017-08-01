package org.fsd.com.mina.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Iterator;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.fsd.com.mina.server.ServerHandler;
import org.fsd.com.test.Constant;

public class MinaClientSample {
	static String text = null;

	public static void main(String[] args) throws IOException {
		testSend(Constant.IP_ADDR,Constant.PORT);
		// sendToAll();
	}

	public static void testSend(String ip, int port) {
		// 创建客户端连接器.
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8")))); // 设置编码过滤器
		connector.setHandler(new ClientHandler());// 设置事件处理器
		ConnectFuture cf = connector.connect(new InetSocketAddress(ip, port));// 建立连接
		cf.awaitUninterruptibly();// 等待连接创建完成
		cf.getSession().write("hello,测试！");// 发送消息
		/*cf.getSession().closeOnFlush();
		cf.getSession().getCloseFuture().awaitUninterruptibly();// 等待连接断开
		connector.dispose();*/
	}

	/**
	 * 模拟群发，在服务端和客户端都启动之后，可以运行此方法群发消息
	 * 
	 * @throws @date
	 *             2017年7月25日 下午3:10:47
	 */
	public static void sendToAll() {
		System.out.println(ServerHandler.sessions.size());
		for (Iterator<?> iterator = ServerHandler.sessions.iterator(); iterator.hasNext();) {
			IoSession session = (IoSession) iterator.next();
			session.write("发送系统消息");
		}
	}
}
