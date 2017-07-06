package spring.chapter_02WiringBean.service.impl;

import spring.chapter_02WiringBean.service.Poem;

public class Sonnet29 implements Poem {

	@Override
	public void recite() {
		System.out.println("When ,in disgrace with Fortune and men’ eyes ,I all alone beweep my outcast state," +
				"And trouble deaf heaven with my bootless cries ," +
				" And look upon myself ,and curse my fate .");
	}

}
