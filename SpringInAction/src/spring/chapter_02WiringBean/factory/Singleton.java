package spring.chapter_02WiringBean.factory;

/**
 * 内部类实现单例模式
 * 
 * @author Administrator
 *
 * 2016-6-12 下午02:15:49
 */
public class Singleton {
	private Singleton(){}
	
	private static class SingletonHolder{
		static Singleton instance=new Singleton();//延迟加载实例
	}
	
	public static Singleton getInstance(){
		return SingletonHolder.instance;
	}
	
}
