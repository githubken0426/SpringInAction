package spring.chapter_03SpringXML.service.impl;

import org.springframework.stereotype.Service;

import spring.chapter_03SpringXML.inter.StringedInstrument;
import spring.chapter_03SpringXML.service.Instrument;

/**
 * 利用限定注解器，限制装配对象
 * @author Administrator
 *
 * 2016-6-13 下午03:17:00
 */
@StringedInstrument
@Service(value="samphone")
public class Samphone implements Instrument{

	@Override
	public void play() {
		System.out.println("Samphone playing....!");
	}

}
