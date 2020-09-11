package cn.ebing.dog.api.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new
				// config类主要完成对类的扫描
				AnnotationConfigApplicationContext(Config.class);
		Service service = (Service) ac.getBean("service");
		service.test();
	}
}
