package spring.chapter_01.action;

import spring.chapter_01.service.Knight;


/**
 * set注入
 * @param knight
 * @date 2017年7月6日 上午18:21:23
 */
public class SetKnightAction {
	private Knight knight;
	
	public void setKnight(Knight knight) {
		this.knight = knight;
	}

	public void doSomething(){
		System.out.println("set 注入");
		knight.embarkOnQuest();
	}
}
