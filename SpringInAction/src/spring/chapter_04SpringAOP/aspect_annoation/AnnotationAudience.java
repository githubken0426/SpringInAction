package spring.chapter_04SpringAOP.aspect_annoation;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationAudience {
	
	@Pointcut("execution(* spring.chapter_04SpringAOP.service..*.*(..))")
	public void performeance(){
		/**
		 * 该方法仅是一个标识，供@Pointcut注解依附
		 */
	}
	@Before("performeance()")
	public void takeSeats(){
		System.out.println("AnnotationAudience==> The audiences taking their seats!");
	}
	
	@Before("performeance()")
	public void turnOffCellPhone(){
		System.out.println("AnnotationAudience==> The audiences turn off their phones!");
	}
	
	@AfterReturning("performeance()")
	public void applaud(){
		System.out.println("AnnotationAudience==> After showing！");
	}
	
	@AfterThrowing("performeance()")
	public void demandRefund(){
		System.out.println("AnnotationAudience==> 表演失败！Boo! We wont our money back!");
	}
	/**
	 * 标注环绕通知
	 * @param joinPoint
	 */
	@Around("performeance()")
	public void watchAround(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("AnnotationAudience Arround==> 表演之前，请关闭手机！");
			long start=System.currentTimeMillis();
			/**
			 * 目标方法可以多次调用，也可以不调用
			 */
			joinPoint.proceed();
			TimeUnit.SECONDS.sleep(1);
			long end=System.currentTimeMillis();
			System.out.println(joinPoint.getClass().getSimpleName());
			System.out.println("AnnotationAudience Arround==> 表演结束！");
			System.out.println("AnnotationAudience Arround==> 表演持续时间:"+(end-start));
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("AnnotationAudience Arround==> 表演失败！退钱了...");
		}
		
	}
}
