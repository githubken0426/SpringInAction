package spring.chapter_03SpringXML.service.impl;

import org.springframework.stereotype.Service;

import spring.chapter_03SpringXML.service.Instrument;

@Service(value="saxophone")
//@Qualifier("saxophone")
public class Saxophone implements Instrument {

	@Override
	public void play() {
		System.out.println("Saxophone Too Too Oh Oh....!");
	}

}
