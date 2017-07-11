package IoC.normal.action;

import IoC.normal.service.Knight;

public class RedKnightAction {
	/**
	 * constructor注入
	 */
	private Knight knight;
	public RedKnightAction(Knight knight){
		this.knight =knight;
	}
	
	public void doSomething(){
		System.out.println("constructor 注入");
		knight.embarkOnQuest();
	}
}
