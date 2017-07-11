package IoC.normal.service;

import IoC.normal.bean.Quest;

/**
 * 光明骑士
 * @author Administrator
 * 2016-7-11 下午04:05:00
 */
public class RedCrossKnight implements Knight {
	private Quest quest;
	public RedCrossKnight(Quest quest){
		this.quest=quest;
	}
	@Override
	public void embarkOnQuest() {
		System.out.println("我是光明骑士!");
		quest.emark();
	}
}
