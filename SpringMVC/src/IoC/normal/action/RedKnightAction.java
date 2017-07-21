package IoC.normal.action;

import IoC.normal.service.Knight;

public class RedKnightAction {
	/**
	 * constructor注入
	 */
	private Knight knight;
	public RedKnightAction(Knight knight){
		System.out.println("constructor注入:"+knight.getClass().getSimpleName());
		this.knight =knight;
	}
	
	public void doSomething(){
		knight.embarkOnQuest();
	}
}
