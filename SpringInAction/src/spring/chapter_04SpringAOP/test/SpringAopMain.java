package spring.chapter_04SpringAOP.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_04SpringAOP.service.Constant;
import spring.chapter_04SpringAOP.service.Performer;
import spring.chapter_04SpringAOP.service.Thinker;
import spring.util.XMLClassPath;

/**
 * 测试类
 * 
 * @author Administrator
 * 
 *         2016-6-14 上午09:54:54
 */
public class SpringAopMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				XMLClassPath.XML_CHAPTER_04_PATH);
		Performer juggler = (Performer) context.getBean("juggler");
		juggler.perform();
		
		
		
		
		
		
		
		
		
		
		
		

		// Constant constant=(Constant) juggler;
		// constant.receiveAward();

		System.out.println("****************************************");
		// Thinker thinker=(Thinker) context.getBean("thinkerImpl");
		// thinker.thinkOfSomething("I am the winner!");

	}
}
