package org.fsd.com.mina.client;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.fsd.com.MinaProperties;

public class ClientHandler extends IoHandlerAdapter {
	private final Logger LOG = Logger.getLogger(ClientHandler.class);

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		LOG.warn("客户端收到消息：" + message);
		if (message.toString().equals(MinaProperties.HEARTBEAT_REQUEST)) {
			// 收到心跳包
			LOG.warn("收到心跳包");
			session.write(MinaProperties.HEARTBEAT_RESPONSE);
		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		LOG.warn("session 空闲");
		super.sessionIdle(session, status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
	}
}
