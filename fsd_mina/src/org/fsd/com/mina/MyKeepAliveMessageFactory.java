package org.fsd.com.mina;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;

public class MyKeepAliveMessageFactory implements  KeepAliveMessageFactory{
	static {
		System.out.println(MyKeepAliveMessageFactory.class.getCanonicalName());
	}
	private final Logger LOG = Logger.getLogger(MyKeepAliveMessageFactory.class);

	/** 心跳包内容 */
	private static final String HEARTBEATREQUEST = "1111";
	private static final String HEARTBEATRESPONSE = "1112";

	public Object getRequest(IoSession session) {
		LOG.warn("请求预设信息: " + HEARTBEATREQUEST);
		return HEARTBEATREQUEST;
	}
	/**
	 * 根据心跳请求request 反回一个心跳反馈消息
	 */
	public Object getResponse(IoSession session, Object request) {
		LOG.warn("响应预设信息: " + HEARTBEATRESPONSE);
		/** 返回预设语句 */
		return HEARTBEATRESPONSE;
	}
	/**
	 * 判断是否心跳请求包, 是返回true
	 */
	public boolean isRequest(IoSession session, Object message) {
		LOG.warn("请求心跳包信息: " + message);
		if (message.equals(HEARTBEATREQUEST))
			return true;
		return false;
	}
	/**
	 * 由于被动型心跳机制，没有请求当然也就不关注反馈 因此直接返回false
	 */
	public boolean isResponse(IoSession session, Object message) {
		LOG.warn("响应心跳包信息: " + message);
		if (message.equals(HEARTBEATRESPONSE))
			return true;
		return false;
	}
	
	private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {
		private final Logger LOG = Logger.getLogger(KeepAliveRequestTimeoutHandlerImpl.class);

		@Override
		public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
			LOG.warn("心跳超时！");
		}
	}
}
