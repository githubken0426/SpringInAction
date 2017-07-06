package spring.chapter_01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_01.action.ConstructorKnightAction;
import spring.chapter_01.action.SetKnightAction;
import spring.chapter_01.bean.Student;

/**
 * 由于是xml声明的bean,所以选择ClassPathXmlAplicationContext作为应用上下文
 * 
 * @author Administrator
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/chapter_01/xml/spring_beans.xml");
		ConstructorKnightAction redKnightAction = (ConstructorKnightAction) context.getBean("redKnightAction");
		redKnightAction.doSomething();
		
		
		System.out.println("****************************");
		SetKnightAction setKnightAction = (SetKnightAction) context.getBean("setRedKnightAction");
		setKnightAction.doSomething();
		
		Student stu = (Student) context.getBean("student");
		System.out.println(stu);
		
	}
}
