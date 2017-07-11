package IoC.normal.service;

import IoC.normal.bean.Quest;

/**
 * 黑暗骑士
 * @author Administrator
 * 2016-7-11 下午04:04:51
 */
public class BlackCrossKnight implements Knight {
	private Quest quest;
	public BlackCrossKnight(Quest quest){
		this.quest=quest;
	}
	@Override
	public void embarkOnQuest() {
		System.out.println("我是黑暗骑士!");
		quest.emark();
	}
}
