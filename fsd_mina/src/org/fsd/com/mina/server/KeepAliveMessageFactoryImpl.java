package org.fsd.com.mina.server;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.fsd.com.MinaProperties;
/**
 * 定义心跳包的内容
 * 目的:读写通道不出现空闲,
 * @ClassName: KeepAliveMessageFactoryImpl 
 * @Description: 
 * @author ken 
 * @date 2017年8月2日 上午10:20:06
 */
public class KeepAliveMessageFactoryImpl implements  KeepAliveMessageFactory{
	static {
		System.out.println(KeepAliveMessageFactoryImpl.class.getCanonicalName());
	}
	private final Logger LOG = Logger.getLogger(KeepAliveMessageFactoryImpl.class);

	public Object getRequest(IoSession session) {
		LOG.warn("响应预设信息: " + MinaProperties.HEARTBEAT_REQUEST);
		/** 返回预设语句 */
		return MinaProperties.HEARTBEAT_REQUEST;
	}
	/**
	 * 根据心跳请求request 反回一个心跳反馈消息
	 */
	public Object getResponse(IoSession session, Object request) {
		LOG.warn("响应预设信息: " + MinaProperties.HEARTBEAT_RESPONSE);
		/** 返回预设语句 */
		return MinaProperties.HEARTBEAT_RESPONSE;
	}
	/**
	 * 判断是否心跳请求包, 是返回true
	 */
	public boolean isRequest(IoSession session, Object message) {
		LOG.warn("请求心跳包信息: " + message);
		if (message.equals(MinaProperties.HEARTBEAT_REQUEST))
			return true;
		return false;
	}
	/**
	 * 由于被动型心跳机制，没有请求当然也就不关注反馈 因此直接返回false
	 */
	public boolean isResponse(IoSession session, Object message) {
		LOG.warn("响应心跳包信息: " + message);
		if (message.equals(MinaProperties.HEARTBEAT_RESPONSE))
			return true;
		return false;
	}
	
	/**
	 * 定义超时后的处理方式
	 */
	/*private static class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {
		private final Logger LOG = Logger.getLogger(KeepAliveRequestTimeoutHandlerImpl.class);

		@Override
		public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
			LOG.warn("心跳超时！");
		}
	}*/
}
