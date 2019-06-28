package cn.ebing.dog.api.service.impl;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;
import cn.ebing.dog.api.mapper.UserMapper;
import cn.ebing.dog.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserResponse getUserById(Integer id) {
		UserEntity user = userMapper.getById(id);
		return new UserResponse(user.getId(), user.getName(), user.getAge(), user.getSex(), user.getCreatedAt());
	}

//	@Override
//	public List<UserResponse> listUsers() {
//		List<UserEntity> users = userMapper.listAll();
//		users.forEach();
//		return arenaDownloadDao.list(map);
//	}

	@Override
	public int saveUser(UserRequest request) {
		UserEntity user = new UserEntity(request.getName(), request.getAge(), request.getSex());
		return userMapper.addOne(user);
	}

//	@Override
//	public int update(ArenaDownloadDO arenaDownload) {
//		return arenaDownloadDao.update(arenaDownload);
//	}
//
//	@Override
//	public int remove(Integer id) {
//		return arenaDownloadDao.remove(id);
//	}
}
