package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;
import cn.ebing.dog.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
	public List<UserEntity> listUsers() {
		logger.debug("== 查询全部用户接口 ==");
		return userService.listUsers();
	}

	@ResponseBody
	@PostMapping
	public Integer add(
		@RequestBody UserRequest request
	) {
		return userService.saveUser(request);
	}

	/**
	 * 2021年06月23日13:55:27
	 * @param userId
	 * @param request
	 * @return
	 *
	 * 1、@RequestBody @Valid 才能校验
	 * 2、如果body里面有级联（cascading）校验，就是嵌套一层一层的，就需要在 filed 里加上 @Valid，
	 * 3、我们看 @Validated 这个是 spring 的注解，不是 javax 的注解，才知道，看 @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER}) 这样的话，这个注解是不能放到字段上的，就是 target 不支持
	 * 4、绕过 springboot 校验，也可以自定义 validCustom，只需要 prefix = valid 就可以，功能是一样的呀
	 * 5 校验流程 {@link org.hibernate.validator.internal.metadata.core.ConstraintHelper }
	 */
	@ResponseBody
	@PutMapping("/{user_id}")
	public Integer update(
		@PathVariable("user_id") Integer userId,
		@RequestBody @Valid @Validated UserRequest request
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