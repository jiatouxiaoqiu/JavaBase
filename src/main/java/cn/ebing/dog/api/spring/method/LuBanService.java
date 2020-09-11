package cn.ebing.dog.api.spring.method;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 原型对象在这种情况下，失去了原型的意义，因为每次都使用的是同一个对象。
 * 那么如何解决这个问题呢？
 * 只要我每次在使用这个Bean的时候都去重新获取就可以了，那么这个时候我们可以通过方法注入来解决。
 */
@Component
@Scope("prototype")
public class LuBanService {
	int i;

	LuBanService() {
		System.out.println("luBan create ");
	}
	// 每次将当前对象的属性i+a然后打印
	public void addAndPrint(int a) {
		i+=a;
		System.out.println(i);
	}
}