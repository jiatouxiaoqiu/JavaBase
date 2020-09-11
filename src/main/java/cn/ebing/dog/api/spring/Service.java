package cn.ebing.dog.api.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component()
//public class Service {
//
//	private LuBanService luBanService;
//
//	public Service() {
//		System.out.println("service create");
//	}
//
//	public void test(){
//		System.out.println(luBanService);
//	}
//	// 通过autowired指定使用set方法完成注入
//	@Autowired
//	public void setLuBanService(LuBanService luBanService) {
//		System.out.println("注入luBanService by setter");
//		this.luBanService = luBanService;
//	}
//}

@Component
public class Service {

	private LuBanService luBanService;

	public Service() {
		System.out.println("service create by no args constructor");
	}

	// 通过Autowired指定使用这个构造函数，否则默认会使用无参
	@Autowired
	public Service(LuBanService luBanService) {
		System.out.println("注入luBanService by constructor with arg");
		this.luBanService = luBanService;
		System.out.println("service create by constructor with arg");
	}

	public void test(){
		System.out.println(luBanService);
	}
}