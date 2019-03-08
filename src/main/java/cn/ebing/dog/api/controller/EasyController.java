package cn.ebing.dog.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/easy")
public class EasyController {

	@ResponseBody
	@GetMapping("/hello")
	public String list() {
		return "hello world";
	}
}
