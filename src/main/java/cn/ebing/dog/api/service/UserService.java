package cn.ebing.dog.api.service;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;

import java.util.List;

public interface UserService {

	int saveUser(UserRequest request, boolean openError);

	int updateUser(Integer id, UserRequest request);
	List<UserEntity> listUsers();

	List<Integer> insertMany(List<UserRequest> userRequests);

	UserEntity getUserById(Integer id);
	UserEntity getUser(Integer id, Integer age);

	void deleteUserById(Integer id);
	void heroTest();
	void saveUser2(UserRequest request);
}
