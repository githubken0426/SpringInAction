package aop.aspect;

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
		System.out.println("Audience takeSeats()==> The audiences taking their seats!");
	}
	/**
	 * 关闭手机
	 */
	public void turnOffCellPhone(){
		System.out.println("Audience turnOffCellPhone()==> The audiences turn off their phones!");
	}
	/**
	 * 表演结束
	 */
	public void applaud(){
		System.out.println("Audience applaud()==> After showing！");
	}
	/**
	 * 表演失败
	 */
	public void demandRefund(){
		System.out.println("Audience demandRefund()==> 表演失败！Boo! We wont our money back!");
	}
	
	public void theEnd(){
		System.out.println("Audience theEnd()==> close door!");
	}
}
