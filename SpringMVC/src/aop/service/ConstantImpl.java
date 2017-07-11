package aop.service;

import org.springframework.stereotype.Service;

@Service(value="constantImpl")
public class ConstantImpl implements Constant {
	@Override
	public void receiveAward() {
		System.out.println("Constant==》 为performer增加新的行为！");
	}

}
