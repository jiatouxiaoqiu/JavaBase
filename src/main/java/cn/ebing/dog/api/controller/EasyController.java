package cn.ebing.dog.api.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
			System.out.println("邱文韬~~~");
		} else {
			System.out.println("qiuhengbin~~~");
		}
		return "wo zai shenzhen，邱文韬";
	}

	@Test
	@ResponseBody
	@PostMapping("/qiuw")
	public String wangbn() {
		System.out.println("接口请求来啦~~~");
		Integer a = 1;
		if (a > 1) {
			System.out.println("邱文韬~~~");
		} else {
			System.out.println("qiuhengbin~~~");
		}
		return "ni zai shenzhen，邱文韬";
	}
}