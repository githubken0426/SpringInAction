package spring.chapter_03SpringXML.bean;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.chapter_03SpringXML.inject.Knife;

public class KnifeJuggler {
	@Inject
	@Named("bigKnife")
//	@Autowired
//	@Qualifier("bigKnife")
	private Knife knife;
	
	private Set<Knife> knives;
	/**
	 * java JCP java依赖注入
	 * 需要javax.inject.jar
	 * @Inject注入一个Provider,Provider接口可以实现bean引用的延迟注入，
	 * 以及注入bean的多个实例功能
	 * @param knifeProvide
	 */
	
	public KnifeJuggler(){}
	
	@Inject
	@Named("bigKnife")//与autowired的qualifier对应
	public KnifeJuggler(javax.inject.Provider<Knife> knifeProvide){
		knives=new HashSet<Knife>();
		for(int i=0;i<5;i++){
			knives.add(knifeProvide.get());
		}
	}
	
	
	public void cutting(){
		System.out.println("构造器注入:"+knives.toString());
		knife.cut();
	}
}
