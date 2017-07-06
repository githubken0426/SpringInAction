package spring.chapter_03SpringXML.service.impl;

import org.springframework.stereotype.Component;

import spring.chapter_03SpringXML.service.Instrument;


/**
 * @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注
 * @Service用于标注业务层组件
 * @Controller用于标注控制层组件（如struts中的action）
 * @Repository用于标注数据访问组件，即DAO组件
 * @author Administrator
 *
 * 2016-6-14 上午08:27:16
 */
@Component(value="sumphone")
public class Sumphone implements Instrument {

	@Override
	public void play() {
		System.out.println("I am @Component!");
	}

}
