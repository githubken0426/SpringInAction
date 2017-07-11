package IoC.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import IoC.annotation.action.RedKnightAction;

/**
 * 应用上下文
 * ClassPathXmlAplicationContext
 * FileSystemXmlApplicationContext
 * XmlWebApplicationContext
 * 
 * @author Administrator
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"IoC/annotation/xml/spring_annotation.xml");
		RedKnightAction redKnightAction = (RedKnightAction) context.getBean("redKnightAction");
		redKnightAction.doSomething();
		
		System.out.println("**********************");
		redKnightAction.doSomethingElse();
	}
}
