package spring.chapter_03SpringXML.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.chapter_03SpringXML.bean.InstrumentList;
import spring.chapter_03SpringXML.bean.KnifeJuggler;
import spring.chapter_03SpringXML.service.impl.Sumphone;
import spring.util.XMLClassPath;

public class AnnotationMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext(XMLClassPath.XML_CHAPTER_03_ANNOTATION_PATH);
		InstrumentList instrument=(InstrumentList) context.getBean("kenny");
		instrument.perform();
		
		KnifeJuggler knifeJuggler=(KnifeJuggler) context.getBean("knifeJuggler");
		knifeJuggler.cutting();
		
		Sumphone conpontent=(Sumphone) context.getBean("sumphone");
		conpontent.play();
		
		System.out.println("duke playing....");
		Sumphone duke=(Sumphone) context.getBean("duke");
		duke.play();
	}
}
