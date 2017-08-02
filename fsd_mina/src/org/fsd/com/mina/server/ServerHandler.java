package org.fsd.com.mina.server;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import net.sf.json.JSONObject;

public class ServerHandler extends IoHandlerAdapter {
	static {
		System.out.println(ServerHandler.class.getCanonicalName());
	}
	private final int IDLE = 2;// 单位秒
	private final Logger LOG = Logger.getLogger(ServerHandler.class);
	public static Set<IoSession> sessions = Collections.synchronizedSet(new HashSet<IoSession>());
	public static ConcurrentHashMap<Long, IoSession> sessionsConcurrentHashMap = new ConcurrentHashMap<Long, IoSession>();

	/**
	 * 当一个新的连接建立时，由I/O processor thread调用
	 */
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		LOG.warn("remote client [" + session.getRemoteAddress().toString() + "] connected.");
		sessions.add(session);
		Long time = System.currentTimeMillis();
		session.setAttribute("id", time);
		sessionsConcurrentHashMap.put(time, session);

	}

	/**
	 * 当连接打开是调用
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception {
		LOG.warn("sessionOpened.");
		session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, IDLE);
	}

	/**
	 * 当连接进入空闲状态时调用
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		LOG.warn("session idle");
	}

	/**
	 * 当接收了一个消息时调用
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		JSONObject json = JSONObject.fromObject(message.toString());
		LOG.warn("客户端" + ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress() + "连接成功！");

		session.setAttribute("type", json);
		String remoteAddress = ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
		session.setAttribute("ip", remoteAddress);
		LOG.warn(json);
		/**
		 * 返回客户端信息
		 */
		json = JSONObject.fromObject("{err_code:'0',err_message:'success'}");
		session.write(json);
	}

	/**
	 * 当一个消息被(IoSession#write)发送出去后调用
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		LOG.warn("messageSent:" + message);

	}

	/**
	 * 当实现IoHandler的类抛出异常时调用
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		LOG.warn("session occured exception, so close it." + cause.getMessage());
		LOG.warn(cause.toString());
	}

	/**
	 * 当连接关闭时调用
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception {
		LOG.warn("sessionClosed.");
		session.closeOnFlush();
		sessions.remove(session);
		sessionsConcurrentHashMap.remove(session.getAttribute("id"));
	}

}
