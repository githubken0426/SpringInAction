package spring.chapter_04SpringAOP.aspect_annoation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationMindreader{
	private String thoughts;
	
	public String getThoughts() {
		return thoughts;
	}
	
	/**
	 * 注解中，and必须换成java语言的&&
	 * 
	 * java.lang.IllegalArgumentException:error at ::0 formal unbound in pointcut 
	 * @param thoughts
	 */
	@Pointcut("execution(* spring.chapter_04SpringAOP.service.Thinker.thinkOfSomething(String)) && args(thoughts))")
	public void thingking(String thoughts){
		
	}
	
	@Before("thingking(thoughts)")
	public void interceptThoughts(String thoughts) {
		this.thoughts=thoughts;
		System.out.println("Mindreader==> Intercepting volunterr's thoughts: "+thoughts);
	}

}
