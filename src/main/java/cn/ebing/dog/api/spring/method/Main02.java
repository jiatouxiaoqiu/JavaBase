package cn.ebing.dog.api.spring.method;

import cn.ebing.dog.api.spring.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		/**
		 * myService 这个不填的话，默认小驼峰？？？
		 */
		MyService service = (MyService) ac.getBean("wc");
		service.test(1);
		service.test(2);
		service.test(3);
	}
}