package spring.chapter_02WiringBean.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_02WiringBean.bean.Auditorium;
import spring.chapter_02WiringBean.bean.InstrumentList;
import spring.chapter_02WiringBean.factory.Singleton;
import spring.chapter_02WiringBean.service.Performer;
import spring.chapter_02WiringBean.service.impl.OneManBand;

public class WiringBeanMian {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring/chapter_02WiringBean/xml/spring_beans.xml");
		Performer performer=(Performer) context.getBean("juggler");
		performer.perform();
		Singleton singleton=(Singleton) context.getBean("singleton");
		System.out.println("单例:"+singleton);
		
//		TimeUnit.SECONDS.sleep(10);
		Auditorium auditorium=(Auditorium) context.getBean("auditorium");
	
		InstrumentList instrumentList=(InstrumentList) context.getBean("kenny");
		instrumentList.perform();
		
		OneManBand oneManBand=(OneManBand) context.getBean("oneManBand");
		oneManBand.perform();
		oneManBand.iteratorMap();
		oneManBand.iteratorProperties();
		oneManBand.iteratorMapStr();
		System.out.println("为属性name注入Null:"+oneManBand.getName());
		System.out.println("SpEL:"+oneManBand.getSpEL());
 	}
}
