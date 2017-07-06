package spring.chapter_04SpringAOP.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_04SpringAOP.service.Constant;
import spring.chapter_04SpringAOP.service.Performer;
import spring.chapter_04SpringAOP.service.Thinker;
import spring.util.XMLClassPath;

/**
 * 测试类：基于注解的AOP实现
 * @author Administrator
 *
 * 2016-6-15 上午10:56:34
 */
public class SpringAOPAnnotationMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(XMLClassPath.XML_CHAPTER_04_ANNOTATION_PATH);
//		Performer juggler=(Performer) context.getBean("juggler");
//		juggler.perform();
//		System.out.println("****************************************");
//		Constant constant=(Constant) juggler;
//		constant.receiveAward();
		
		System.out.println("****************************************");
		Thinker thinker=(Thinker) context.getBean("thinkerImpl");
		thinker.thinkOfSomething("我的想法是注解!");
	}
}
