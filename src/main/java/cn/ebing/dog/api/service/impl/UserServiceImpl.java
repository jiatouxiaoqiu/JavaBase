package cn.ebing.dog.api.service.impl;

import cn.ebing.dog.api.converter.UserConverter;
import cn.ebing.dog.api.domain.business.Hero;
import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.query.UserQuery;
import cn.ebing.dog.api.domain.request.UserRequest;
import cn.ebing.dog.api.mapper.UserMapper;
import cn.ebing.dog.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserConverter converter;

	@Autowired
	private UserService userService;

	@Override
	public UserEntity getUserById(Integer id) {
		UserEntity user = userMapper.getById(id);
		if (user == null) {
			throw new RuntimeException("USER 不存在----");
		}
		return user;
	}

	@Override
	public UserEntity getUser(Integer id, Integer age) {
		return userMapper.getById(id, age);
	}

	@Override
	public List<UserEntity> listUsers() {
		LocalDateTime minCreateTime = LocalDateTime.now();
		UserQuery query = new UserQuery();
		query.setMinCreateTime(minCreateTime);
		List<UserEntity> users = userMapper.listByQuery(query);
		return users;
	}

	/**
	 * 测试事务，插入这个的时候，再插入其他，然后报错，然后回来。这样的话，主键会浪费吗？
	 * @param request
	 * @return
	 */
	/**
	 * 主键id，可以在xml配置后，可以通过 user.getId拿到。
	 * addOne xml 的返回值，是影响行数，插入1条，result == 1
	 */
	@Override
	@Transactional
	public int saveUser(UserRequest request, boolean openError) {
		UserEntity user = new UserEntity(request.getName(), request.getAge(), request.getSex());
		int id = userMapper.addOne(user);


		return id;
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

	@Override
	public List<Integer> insertMany(List<UserRequest> userRequests) {
		if (userRequests.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		/**
		 * 前提要求：
		 *
		 *  1、升级Mybatis版本到3.3.1
		 * 	2、在mapper.java中不能使用@param注解。
		 * 	3、Mapper.xml中使用list变量接受Dao中的集合。
		 * 	4、xxxDao中,也只能传一个LIST参数. 两个参数是不行的
		 *
		 * 	获得ids, 就是 entities.stream().map(UserEntity::getId).collect(Collectors.toList());
		 * 	影响行数就是: total
		 */
		List<UserEntity> entities = converter.request2entities(userRequests);
		int total = userMapper.insertMany(entities);
		return entities.stream().map(UserEntity::getId).collect(Collectors.toList());
	}
}
