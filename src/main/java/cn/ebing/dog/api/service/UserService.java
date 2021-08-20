package cn.ebing.dog.api.service;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;

import java.util.List;

public interface UserService {
	int saveUser(UserRequest request);
	int updateUser(Integer id, UserRequest request);
	List<UserEntity> listUsers();

	UserEntity getUserById(Integer id);
	UserEntity getUser(Integer id, Integer age);

	void deleteUserById(Integer id);
	void heroTest();
	void saveUser2(UserRequest request);
}
