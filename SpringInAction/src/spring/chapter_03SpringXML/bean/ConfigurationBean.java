package spring.chapter_03SpringXML.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.chapter_03SpringXML.service.Instrument;
import spring.chapter_03SpringXML.service.impl.Sumphone;
/**
 * @Configuration元素等价于xml中的<beans>元素。
 * 
 * @author Administrator
 *
 * 2016-6-14 上午09:33:16
 */
@Configuration
public class ConfigurationBean {
	/**
	 * @Bean等价于xml中<bean id="duke" class="...">
	 * 
	 * @return
	 */
	@Bean
	public Instrument duke(){
		return new Sumphone();
	}
}
