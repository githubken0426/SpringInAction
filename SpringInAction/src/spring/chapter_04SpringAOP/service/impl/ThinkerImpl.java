package spring.chapter_04SpringAOP.service.impl;

import org.springframework.stereotype.Service;

import spring.chapter_04SpringAOP.service.Thinker;

@Service(value="thinkerImpl")
public class ThinkerImpl implements Thinker {
	private String thoughts;
	
	public String getThoughts() {
		return thoughts;
	}

	@Override
	public void thinkOfSomething(String thoughts) {
		this.thoughts=thoughts;
	}

}
