package spring.chapter_02WiringBean.bean;

/**
 * 初始化和销毁bean
 * @author Administrator
 *
 * 2016-6-13 上午08:30:26
 */
public class Auditorium {
	public void turnOnLights(){
		System.out.println("Initializable bean!");
	}
	
	public void turnOffLights(){
		System.out.println("Destory bean!");
	}
}
