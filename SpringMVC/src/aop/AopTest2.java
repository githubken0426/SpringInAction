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
public class AopTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop/xml/spring_aop2.xml");
		Performer juggler = (Performer) context.getBean("performer");
		/**
		 * 引入
		 */
		Constant constant=(Constant) juggler;
		constant.receiveAward();
	}
}
