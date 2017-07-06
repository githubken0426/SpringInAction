package spring.chapter_04SpringAOP.service.impl;

import org.springframework.stereotype.Service;

import spring.chapter_04SpringAOP.service.Performer;

@Service(value="juggler")
public class Juggler implements Performer {
	@Override
	public void perform() {
		System.out.println("目标方法:杂技表演");
//		throw new UnsupportedOperationException();
	}

	
	private int beanBags=3;
	
	public Juggler(){}
	
	public Juggler(int beanBags){
		this.beanBags=beanBags;
	}
	
	
}
