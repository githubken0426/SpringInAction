package aop.service;

import org.springframework.stereotype.Service;

@Service(value="performer")
public class PerformerImpl implements Performer {
	
	@Override
	public void perform() {
		System.out.println("目标方法:杂技表演");
//		throw new UnsupportedOperationException();
	}

}
