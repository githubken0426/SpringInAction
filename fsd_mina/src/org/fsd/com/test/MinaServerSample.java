package org.fsd.com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MinaServerSample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("spring_mina.xml");
	}
}
