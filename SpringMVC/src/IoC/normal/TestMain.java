package IoC.normal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import IoC.normal.action.BlackKnightAction;
import IoC.normal.action.RedKnightAction;
import IoC.normal.bean.Student;


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
				"IoC/normal/xml/spring_beans.xml");
		RedKnightAction redKnightAction = (RedKnightAction) context.getBean("redAction");
		redKnightAction.doSomething();
		
		
		System.out.println("****************************");
		BlackKnightAction setKnightAction = (BlackKnightAction) context.getBean("blackAction");
		setKnightAction.doSomething();
		
		System.out.println("****************************");
		Student stu = (Student) context.getBean("student");
		System.out.println(stu);
		
	}
}
