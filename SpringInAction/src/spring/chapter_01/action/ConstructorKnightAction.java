package spring.chapter_01.action;

import spring.chapter_01.service.Knight;



public class ConstructorKnightAction {
	/**
	 * constructor注入
	 */
	private Knight knight;
	public ConstructorKnightAction(Knight knight){
		this.knight =knight;
	}
	
	public void doSomething(){
		System.out.println("constructor 注入");
		knight.embarkOnQuest();
	}
}
