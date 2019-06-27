package cn.ebing.dog.api.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{userId}")
	public String getById() {
		return "hello world";
	}

	@GetMapping("")
	public List<String> listUsers() {
		return ArrayList;
	}


	@PostMapping
	public String add() {
		System.out.println("-- 删除 user 接口请求开始 --");
		System.out.println("接口请求来啦~~~");
		Integer a = 1;
		if (a > 1) {
			System.out.println("邱文韬~~~");
		} else {
			System.out.println("qiuhengbin~~~");
		}
		return "wo zai shenzhen，邱文韬";
	}

	@PutMapping("/{userId}")
	public String update() {
		System.out.println("-- 删除 user 接口请求开始 --");
		Integer a = 1;
		if (a > 1) {
			System.out.println("邱文韬~~~");
		} else {
			System.out.println("qiuhengbin~~~");
		}
		return "ni zai shenzhen，邱文韬";
	}

	@DeleteMapping("/{userId}")
	public void delete() {
		System.out.println("-- 删除 user 接口请求开始 --");
		System.out.println("接口请求来啦~~~");
		Integer a = 1;
		if (a > 1) {
			System.out.println("邱文韬~~~");
		} else {
			System.out.println("qiuhengbin~~~");
		}
	}
}