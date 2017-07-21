package aop.service;

import org.springframework.stereotype.Service;


@Service(value="thinkerImpl")
public class ThinkerImpl implements Thinker {
	
	@Override
	public void thinkOfSomething(String thoughts) {
		System.out.println("ThinkerImpl==>参数thoughts："+thoughts);
	}

}
