package cn.ebing.dog.api.service;

import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;

import java.util.List;

public interface UserService {
	int saveUser(UserRequest request);
	int updateUser(Integer id, UserRequest request);
	List<UserResponse> listUsers();
	UserResponse getUserById(Integer id);
	void deleteUserById(Integer id);
}
