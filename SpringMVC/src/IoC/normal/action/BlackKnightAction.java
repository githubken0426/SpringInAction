package IoC.normal.action;

import IoC.normal.service.Knight;

public class BlackKnightAction {
	/**
	 * set 注入
	 */
	private Knight knight;
	
	public void setKnight(Knight knight) {
		this.knight = knight;
	}

	public void doSomething(){
		System.out.println("set 注入");
		knight.embarkOnQuest();
	}
}
