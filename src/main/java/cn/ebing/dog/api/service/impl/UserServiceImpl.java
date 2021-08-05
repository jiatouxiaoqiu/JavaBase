package cn.ebing.dog.api.service.impl;

import cn.ebing.dog.api.domain.business.Hero;
import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.query.UserQuery;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.domain.response.UserResponse;
import cn.ebing.dog.api.mapper.UserMapper;
import cn.ebing.dog.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@Override
	public UserResponse getUserById(Integer id) {
		logger.debug("开始进行 getUserById");
		UserEntity user = userMapper.getById(id);
		UserEntity user2 = new UserEntity();
		if (user == null) {
			throw new RuntimeException("USER 不存在----");
		}
		logger.debug("找到了数据，准备返回");
		return null;
	}

	@Override
	public List<UserEntity> listUsers() {
		LocalDateTime minCreateTime = LocalDateTime.now();
		UserQuery query = new UserQuery();
		query.setMinCreateTime(minCreateTime);
		List<UserEntity> users = userMapper.listByQuery(query);
		return users;
	}

	@Override
	public int saveUser(UserRequest request) {
		saveUser2(request);
		return 1;
	}

	@Override
	@Transactional
	public void saveUser2(UserRequest request) {
		UserEntity user = new UserEntity(request.getName(), request.getAge(), request.getSex());
		userMapper.addOne(user);
	}

	@Override
	public int updateUser(Integer id, UserRequest request) {
//		UserEntity user = new UserEntity(id, request.getName(), request.getAge(), request.getSex());
		return 1;
	}

	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteById(id);
	}

	/**
	 * 策略模式
	 * @param heroList
	 * @param predicate
	 * @return
	 */
	public static List<Hero> getHero(List<Hero> heroList, Predicate<Hero> predicate){
		List<Hero> result = new ArrayList<Hero>();
		for(Hero hero : heroList){
			if(predicate.test(hero)){
				result.add(hero);
			}
		}
		return result;
	}

	@Override
	public void heroTest() {

		/**
		 * 当lambda用于取代匿名内部类时，它与匿名内部类的本质区别是什么呢
		 * 答：简化缩写而已
		 */
		getHero(new ArrayList<Hero>(), new Predicate<Hero>() {
			@Override
			public boolean test(Hero t) {
				return t.getStature() > 170 && "刺客".equals(t.getType());
			}
		});

		getHero(new ArrayList<Hero>(), (t)->t.getStature() > 170 && "刺客".equals(t.getType()));
	}
}
