package org.fsd.com.test;

import org.fsd.com.service.PartnerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MinaServerSample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
		PartnerService loginService =(PartnerService) ct.getBean("xxxService");
		
	}
}
