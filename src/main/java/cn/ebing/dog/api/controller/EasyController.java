package cn.ebing.dog.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/easy")
public class EasyController {

	@ResponseBody
	@GetMapping("/hello")
	public String list() {
		return "hello world";
	}


	@ResponseBody
	@GetMapping("/qiuwentao")
	public String wangbadan() {
		System.out.println("接口请求来啦~~~");
		Integer a = 1;
		if (a > 1) {
			System.out.println("11~~~");
		} else {
			System.out.println("11~~~");
		}
		return "wo zai 111，1";
	}

	@ResponseBody
	@PostMapping("/set")
	public String set() {
		Set<Integer> set1 = new HashSet<>();

		for (int i =0; i<100; i++) {
			set1.add(i);
			set1.remove(i-1);
		}

		System.out.println(set1.size());

		Set<Short> set2 = new HashSet<>();

		for (short i =0; i<100; i++) {
			set2.add(i);
			set2.remove(i-1);
		}

		System.out.println(set2.size());

		Object i = 1 == 1 ? new Integer(3) : new Float(1);
		System.out.println(i);
		return "success";
	}
}