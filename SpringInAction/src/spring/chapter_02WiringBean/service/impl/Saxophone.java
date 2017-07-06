package spring.chapter_02WiringBean.service.impl;

import spring.chapter_02WiringBean.service.Instrument;

public class Saxophone implements Instrument {

	@Override
	public void play() {
		System.out.println("Saxophone Too Too Oh Oh....!");
	}

}
