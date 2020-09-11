package cn.ebing.dog.api.spring.method;

import com.sun.istack.internal.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component("wc")
//public class MyService {
//
//	@Autowired
//	private LuBanService luBanService;
//
//	public void test(int a){
//		luBanService.addAndPrint(a);
//	}
//}

@Component
public class MyService implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public void test(int a) {
		LuBanService luBanService = ((LuBanService) applicationContext.getBean("luBanService"));
		luBanService.addAndPrint(a);
	}

	@Override
	public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
