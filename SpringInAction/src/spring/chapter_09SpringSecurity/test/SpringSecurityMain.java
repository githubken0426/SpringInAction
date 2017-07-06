package spring.chapter_09SpringSecurity.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.util.XMLClassPath;

public class SpringSecurityMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(XMLClassPath.XML_CHAPTER_09_PATH);
		Log logger = LogFactory.getLog(SpringSecurityMain.class);  
		logger.debug("test");
	}
}
