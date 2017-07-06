package spring.chapter_04SpringAOP.service.impl;

import org.springframework.stereotype.Service;

import spring.chapter_04SpringAOP.service.Constant;

@Service(value="constantImpl")
public class ConstantImpl implements Constant {

	@Override
	public void receiveAward() {
		System.out.println("Constant==》 Constant接口的实现类！");
	}

}
