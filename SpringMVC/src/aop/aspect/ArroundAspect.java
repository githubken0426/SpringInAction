package aop.aspect;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面：环绕通知
 * proceed()方法用来来执行目标方法，也就是切入点(pointcut)方法
 * @author Administrator
 *
 * 2016-6-14 上午11:53:46
 */
public class ArroundAspect {
	public void watchAround(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("ArroundAspect==> 表演之前，请关闭手机！");
			long start=System.currentTimeMillis();
			joinPoint.proceed();//目标方法可以被调用也可以不被调用，也可以调用多次。时
			
			TimeUnit.SECONDS.sleep(1);
			long end=System.currentTimeMillis();
//			System.out.println(joinPoint.getClass().getSimpleName());
			System.out.println("ArroundAspect==> 表演结束,持续时间:"+(end-start));
			/**
			 * 目标方法可以多次调用
			 */
//			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("ArroundAspect==> 表演失败！退钱了...");
		}
		
	}
}
