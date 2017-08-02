package org.fsd.com;

import org.apache.commons.lang.StringUtils;
import org.fsd.com.util.FileUtil;
import org.fsd.com.util.PropertiesManager;
import org.fsd.com.util.PropertyPathBean;

/**
 * 项目配置文件
 * 
 * @author
 * 
 */
public final class MinaProperties {

	/**
	 * 项目配置文件管理器，支持热加载
	 */
	public static final PropertiesManager MINA_PROPERTIES = new PropertiesManager(
			FileUtil.getClassesPath(new PropertyPathBean()) + "resources/mina.properties");
	//服务器ip
	public static final String SERVER_IP = MINA_PROPERTIES.getValue("server_ip");
	//服务器端口
	private static final String PORT = MINA_PROPERTIES.getValue("server_port");
	public static final Integer SERVER_PORT = StringUtils.isNotBlank(PORT) ? Integer.valueOf(PORT) : 0;
	//心跳包请求信息
	public static final String HEARTBEAT_REQUEST = MINA_PROPERTIES.getValue("heartbeat_request");
	//心跳包相应信息
	public static final String HEARTBEAT_RESPONSE = MINA_PROPERTIES.getValue("heartbeat_response");
	//空闲时间
	public static final String IDLE = MINA_PROPERTIES.getValue("channel_idle");
	public static final Integer CHANNEL_IDLE = StringUtils.isNotBlank(IDLE) ? Integer.valueOf(IDLE) : 0;
	
}