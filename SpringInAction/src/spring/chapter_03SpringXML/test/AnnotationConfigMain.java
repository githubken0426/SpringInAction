package spring.chapter_03SpringXML.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_03SpringXML.bean.CopyOfInstrumentList;

public class AnnotationConfigMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring/chapter_03SpringXML/xml/spring_annotation_config.xml");
		CopyOfInstrumentList copyOfInstrumentList=(CopyOfInstrumentList) context.getBean("copyOfInstrumentList");
		copyOfInstrumentList.perform();
	}
}
