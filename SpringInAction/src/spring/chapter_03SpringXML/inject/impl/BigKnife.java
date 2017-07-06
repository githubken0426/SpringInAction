package spring.chapter_03SpringXML.inject.impl;

import org.springframework.stereotype.Service;

import spring.chapter_03SpringXML.inject.Knife;


@Service(value="bigKnife")
public class BigKnife implements Knife {

	@Override
	public void cut() {
		System.out.println("A Big Knife cuttting something....！");
	}
}
