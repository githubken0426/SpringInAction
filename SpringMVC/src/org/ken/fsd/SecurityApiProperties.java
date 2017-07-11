package org.ken.fsd;

import org.ken.fsd.util.FileUtil;
import org.ken.fsd.util.PropertiesManager;
import org.ken.fsd.util.PropertyPathBean;

/**
 * 项目配置文件，都应该放在这里
 * 
 * @author
 * 
 */
public class SecurityApiProperties {

	/**
	 * 项目配置文件管理器，支持热加载
	 */
	public static final PropertiesManager WO_SECURITY_API = new PropertiesManager(
			FileUtil.getClassesPath(new PropertyPathBean()) + "resources/securityApi.properties");
}