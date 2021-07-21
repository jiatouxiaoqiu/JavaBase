package cn.ebing.dog.api.service;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;

import java.util.List;

public interface UserService {
	int saveUser(UserRequest request);
	int updateUser(Integer id, UserRequest request);
	List<UserEntity> listUsers();
	UserResponse getUserById(Integer id);
	void deleteUserById(Integer id);
	void heroTest();
	void saveUser2(UserRequest request);
}
