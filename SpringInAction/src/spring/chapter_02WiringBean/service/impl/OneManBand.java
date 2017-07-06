package spring.chapter_02WiringBean.service.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;


import spring.chapter_02WiringBean.service.Instrument;
import spring.chapter_02WiringBean.service.Performer;

public class OneManBand implements Performer {
	private Collection<Instrument> instruments;
	private Map<String,Instrument> map;
	/**
	 * 当map的key和value都为是String类型时候
	 * 可以用java.util.Properties来代替map
	 */
	private Properties prototype;
	private Map<String,String> mapStr;
	private String name;
	private String SpEL;
	
	public Collection<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Map<String, Instrument> getMap() {
		return map;
	}

	public void setMap(Map<String, Instrument> map) {
		this.map = map;
	}
	
	public Map<String, String> getMapStr() {
		return mapStr;
	}

	public void setMapStr(Map<String, String> mapStr) {
		this.mapStr = mapStr;
	}
	
	public Properties getPrototype() {
		return prototype;
	}

	public void setPrototype(Properties prototype) {
		this.prototype = prototype;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSpEL() {
		return SpEL;
	}

	public void setSpEL(String spEL) {
		SpEL = spEL;
	}

	@Override
	public void perform() {
		System.out.println();
		System.out.println("List和set注入的区别：");
		for (Instrument ins : instruments) {
			ins.play();
		}
	}
	
	public void iteratorMap(){
		System.out.println();
		System.out.println("便利Map：");
		for (String key : map.keySet()) {
			System.out.println(key);
			map.get(key).play();
		}
	}
	
	public void iteratorProperties(){
		System.out.println();
		System.out.println("便利Properties：");
		System.out.println(prototype);
	}
	
	public void iteratorMapStr(){
		System.out.println();
		System.out.println("便利mapStr：");
		System.out.println(mapStr);
	}
}
