package spring.chapter_03SpringXML.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import spring.chapter_03SpringXML.inter.StringedInstrument;
import spring.chapter_03SpringXML.service.Instrument;


/**
 * 乐器清单类
 * @author Administrator
 *
 * 2016-6-13 上午09:02:09
 */
public class InstrumentList {
	/**
	 * 使用通过SpEl使用@Value注入
	 */
//	@Value("#{}")
	private String song;
	/**
	 * required=false允许null值
	 * 1.当有多个接口实现时候，需要指定注入的实现对象名称
	 * 
	 * 2.利用限定注解器，限制装配对象
	 */
	@Autowired(required=false)
//	@Qualifier("samphone") //指定名称
	@StringedInstrument
	private Instrument instrument;
	
	public InstrumentList(){}
	
	public InstrumentList(Instrument instrument){
		this.instrument=instrument;
	}
	
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
