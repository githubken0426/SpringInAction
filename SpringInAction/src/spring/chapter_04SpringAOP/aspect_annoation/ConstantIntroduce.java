package spring.chapter_04SpringAOP.aspect_annoation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import spring.chapter_04SpringAOP.service.Constant;
/**
 * 注解引入
 * @author Administrator
 *
 * 2016-6-15 下午01:13:29
 */
@Aspect
@Component
public class ConstantIntroduce {
	
	@DeclareParents(value="spring.chapter_04SpringAOP.service.Performer+",defaultImpl=AnnotationConstantImpl.class)
	public static Constant constant;
}
