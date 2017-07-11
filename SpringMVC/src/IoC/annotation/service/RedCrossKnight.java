package IoC.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IoC.annotation.bean.Quest;


/**
 * @Service 常用于标注业务层组件
 * 
 * @author Administrator
 * 2016-7-11 下午04:05:00
 */
@Service(value="redCrossKnight")
public class RedCrossKnight implements Knight {
	/**
	 * @Autowired可以对成员变量、方法和构造函数进行标注,来完成自动装配的工作.
	 * @Autowired默认是按照类型装配注入的，默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它required属性为false
	 */
	@Autowired(required=false)
	private Quest quest;
	
	@Override
	public void embarkOnQuest() {
		System.out.println("我是光明骑士!");
		quest.emark();
	}
}
