package spring.chapter_04SpringAOP.aspect;

/**
 * 观众类
 * @author Administrator
 * 2016-7-11 下午04:40:17
 */
public class Audience {
	/**
	 * 按票入座
	 */
	public void takeSeats(){
		System.out.println("Audience==> The audiences taking their seats!");
	}
	/**
	 * 关闭手机
	 */
	public void turnOffCellPhone(){
		System.out.println("Audience==> The audiences turn off their phones!");
	}
	/**
	 * 表演结束
	 */
	public void applaud(){
		System.out.println("Audience==> After showing！");
	}
	/**
	 * 表演失败
	 */
	public void demandRefund(){
		System.out.println("Audience==> 表演失败！Boo! We wont our money back!");
	}
}
