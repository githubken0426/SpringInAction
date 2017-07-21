package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.service.Constant;
import aop.service.Performer;


/**
 * 测试类
 * 
 * @author Administrator
 * 
 *         2016-6-14 上午09:54:54
 */
public class AopTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop/xml/spring_aop.xml");
		Performer juggler = (Performer) context.getBean("performer");
		juggler.perform(120);

		/*Constant constant=(Constant) juggler;
		constant.receiveAward();*/
	}
}
