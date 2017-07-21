package IoC.normal.action;

import IoC.normal.service.Knight;

public class BlackKnightAction {
	/**
	 * set 注入
	 */
	private Knight knight;
	
	public void setKnight(Knight knight) {
		System.out.println("set注入: "+ knight.getClass().getSimpleName());
		this.knight = knight;
	}

	public void doSomething(){
		knight.embarkOnQuest();
	}
}
