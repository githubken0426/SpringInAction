package IoC.annotation.bean;

import org.springframework.stereotype.Component;

/**
 * @Component 泛指组件,当组件不好归类的时候,可以使用这个注解进行标注
 * @author Administrator
 *
 * 2016-7-11 下午04:03:29
 */
@Component
public class Quest {
	public void emark(){
		System.out.println("Quest emark!");
	}
}
