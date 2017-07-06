package spring.chapter_02WiringBean.service.impl;

import spring.chapter_02WiringBean.service.Performer;
import spring.chapter_02WiringBean.service.Poem;

public class Juggler implements Performer {
	
	private int beanBags=3;
	private Poem poem;
	
	public Juggler(){}
	
	public Juggler(int beanBags,Poem poem){
		this.beanBags=beanBags;
		this.poem=poem;
	}
	
	@Override
	public void perform() {
		System.out.println("Juggling "+beanBags+" beanbags");
		poem.recite();
	}

}
