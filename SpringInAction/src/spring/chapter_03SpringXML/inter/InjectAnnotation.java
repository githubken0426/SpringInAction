package spring.chapter_03SpringXML.inter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * 使用JSR-330的Qualifier创建注解
 * javax.inject建议使用Qualifier创建注解
 * @author Administrator
 *
 * 2016-6-13 下午04:26:57
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface InjectAnnotation {

}
