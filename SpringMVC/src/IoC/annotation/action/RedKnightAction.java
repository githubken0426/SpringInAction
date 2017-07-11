package IoC.annotation.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import IoC.annotation.service.Knight;

/**
 * @Controller用于标注控制层组件
 * @author ken
 * 
 * @date 2017年7月10日 上午10:39:56
 */
@Controller(value="redKnightAction")
//@Repository(value="redKnightAction")
public class RedKnightAction {
	@Autowired
	private Knight redCrossKnight;
	
	public void doSomething(){
		System.out.println("RedKnightAction-->redCrossKnight:");
		redCrossKnight.embarkOnQuest();
	}
	
	/**
	 * @Qualifier("XXX")中的 XX是 Bean的名称，所以 @Autowired 和 @Qualifier 结合使用时，自动注入的策略就从 byType 转变成 byName 了
	 */
	@Autowired
	@Qualifier("redCrossKnight")
	private Knight knight;
	
	public void doSomethingElse(){
		System.out.println("RedKnightAction-->knight:");
		knight.embarkOnQuest();
	}
}
