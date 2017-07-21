package aop.service;

import org.springframework.stereotype.Service;

@Service(value="performer")
public class PerformerImpl implements Performer {
	
	@Override
	public int perform(int result) {
		System.out.println("\n目标方法:杂技表演,返回值result="+result+"\n");
		if(result<100)
			throw new UnsupportedOperationException();
		return result;
	}

}
