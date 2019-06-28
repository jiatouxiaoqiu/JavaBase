package cn.ebing.dog.api.service.impl;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;
import cn.ebing.dog.api.mapper.UserMapper;
import cn.ebing.dog.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserResponse getUserById(Integer id) {
		UserEntity user = userMapper.getById(id);
		if (user == null) {
			throw new RuntimeException("USER 不存在");
		}
		return new UserResponse(user.getId(), user.getName(), user.getAge(), user.getSex(), user.getCreatedAt());
	}

	@Override
	public List<UserResponse> listUsers() {
		List<UserEntity> users = userMapper.listAll();
		List<UserResponse> list = new ArrayList<UserResponse>();
		users.forEach(user -> {
			list.add(new UserResponse(user.getId(), user.getName(), user.getAge(), user.getSex(), user.getCreatedAt()));
		});
		return list;
	}

	@Override
	public int saveUser(UserRequest request) {
		UserEntity user = new UserEntity(request.getName(), request.getAge(), request.getSex());
		return userMapper.addOne(user);
	}

	@Override
	public int updateUser(Integer id, UserRequest request) {
		UserEntity user = new UserEntity(id, request.getName(), request.getAge(), request.getSex());
		return userMapper.updateOne(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteById(id);
	}
}
