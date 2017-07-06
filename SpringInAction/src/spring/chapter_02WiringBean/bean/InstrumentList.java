package spring.chapter_02WiringBean.bean;

import spring.chapter_02WiringBean.service.Instrument;

/**
 * 乐器清单类
 * @author Administrator
 *
 * 2016-6-13 上午09:02:09
 */
public class InstrumentList {
	private String song;
	private Instrument instrument;
	
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	public void perform(){
		System.out.println("Playing "+song);
		instrument.play();
	}
}
