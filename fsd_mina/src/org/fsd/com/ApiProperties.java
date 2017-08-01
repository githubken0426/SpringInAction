package org.fsd.com;

import org.apache.commons.lang.StringUtils;
import org.fsd.com.util.FileUtil;
import org.fsd.com.util.PropertiesManager;
import org.fsd.com.util.PropertyPathBean;

/**
 * 项目配置文件，都应该放在这里
 * 
 * @author
 * 
 */
public final class ApiProperties {

	/**
	 * 项目配置文件管理器，支持热加载
	 */
	public static final PropertiesManager API_PROPERTIES = new PropertiesManager(
			FileUtil.getClassesPath(new PropertyPathBean()) + "api.properties");
	
	public static final String API_SERVER=API_PROPERTIES.getValue("API_SERVER");
	
	public static final String PORT=API_PROPERTIES.getValue("API_PORT");
}