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
	public static final PropertiesManager API_PROPERTIES = new PropertiesManager(
			FileUtil.getClassesPath(new PropertyPathBean()) + "resources/mina.properties");

	public static final String API_SERVER = API_PROPERTIES.getValue("server_ip");

	private static final String PORT = API_PROPERTIES.getValue("server_port");
	public static final Integer API_PORT = StringUtils.isNotBlank(PORT) ? Integer.valueOf(PORT) : 0;
}