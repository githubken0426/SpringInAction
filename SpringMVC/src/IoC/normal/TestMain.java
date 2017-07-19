package IoC.normal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import IoC.normal.action.BlackKnightAction;
import IoC.normal.action.RedKnightAction;
import IoC.normal.bean.Student;


/**
 * 应用上下文
 * ClassPathXmlAplicationContext 这个方法是从classpath下加载配置文件
 * FileSystemXmlApplicationContext 绝对路径加载配置文件
 * XmlWebApplicationContext 推荐Web项目中使用，获取web应用中的context
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
