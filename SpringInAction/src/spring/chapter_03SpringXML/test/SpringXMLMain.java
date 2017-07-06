package spring.chapter_03SpringXML.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_03SpringXML.bean.InstrumentList;
import spring.util.XMLClassPath;

public class SpringXMLMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(XMLClassPath.XML_CHAPTER_03_PATH);
		InstrumentList instrument=(InstrumentList) context.getBean("kenny");
		instrument.perform();
		InstrumentList instrument2=(InstrumentList) context.getBean("kenny2");
		instrument2.perform();
		
		InstrumentList instrument3=(InstrumentList) context.getBean("kenny3");
		instrument3.perform();
		
		
	}
}
