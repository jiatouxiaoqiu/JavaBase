package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;
import cn.ebing.dog.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ResponseBody
	@GetMapping("/{user_id}")
	public UserResponse getById(
			@PathVariable("user_id") Integer userId
	) {
		logger.debug("== 查询单个用户接口 ==");
		return userService.getUserById(userId);
	}

	@ResponseBody
	@GetMapping
	public List<UserResponse> listUsers() {
		logger.debug("== 查询全部用户接口 ==");
		return userService.listUsers();
	}

	@ResponseBody
	@PostMapping
	public Integer add(
		@RequestBody UserRequest request
	) {
		System.out.println("-- 新增 user 接口请求开始 --");
		return userService.saveUser(request);
	}

	@ResponseBody
	@PutMapping("/{user_id}")
	public Integer update(
		@PathVariable("user_id") Integer userId,
		@RequestBody UserRequest request
	) {
		System.out.println("-- 更新 user 接口请求开始 --");
		return userService.updateUser(userId, request);
	}

	@ResponseBody
	@DeleteMapping("/{user_id}")
	public void delete(
			@PathVariable("user_id") Integer userId
	) {
		System.out.println("-- 删除 user 接口请求开始 --");
		userService.deleteUserById(userId);
	}
}