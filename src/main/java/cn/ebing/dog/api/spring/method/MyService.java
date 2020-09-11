package cn.ebing.dog.api.spring.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wc")
public class MyService {

	@Autowired
	private LuBanService luBanService;

	public void test(int a){
		luBanService.addAndPrint(a);
	}

}
