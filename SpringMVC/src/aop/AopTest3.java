package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.service.Thinker;


/**
 * 目标方法执行前
 * 获取目标方法参数
 * 
 * @author Administrator
 * 
 * 2016-6-14 上午09:54:54
 */
public class AopTest3 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop/xml/spring_aop3.xml");
		System.out.println("****************************************");
		Thinker thinker=(Thinker) context.getBean("thinkerImpl");
		thinker.thinkOfSomething("Thinking In Java!");
	}
}
