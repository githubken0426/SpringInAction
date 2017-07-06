package spring.chapter_04SpringAOP.aspect_annoation;

import org.springframework.stereotype.Service;

import spring.chapter_04SpringAOP.service.Constant;

@Service(value="annotationConstantImpl")
public class AnnotationConstantImpl implements Constant {

	@Override
	public void receiveAward() {
		System.out.println("AnnotationConstantImpl==》 Constant接口的实现类！");
	}

}
