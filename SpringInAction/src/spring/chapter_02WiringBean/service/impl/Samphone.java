package spring.chapter_02WiringBean.service.impl;

import spring.chapter_02WiringBean.service.Instrument;

public class Samphone implements Instrument{

	@Override
	public void play() {
		System.out.println("Samphone playing....!");
	}

}
