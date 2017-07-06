package spring.chapter_01.action;

import spring.chapter_01.service.Knight;



public class KnightAction {
	/**
	 * 注入Knight
	 */
	private Knight knight;
	public KnightAction(Knight knight){
		this.knight =knight;
	}
	
	public void doSomething(){
		knight.embarkOnQuest();
	}
}
