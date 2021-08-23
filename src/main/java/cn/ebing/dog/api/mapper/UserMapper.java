package cn.ebing.dog.api.mapper;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	int addOne(UserEntity entity);
	int insertMany(List<UserEntity> entities);
	int updateOne(UserEntity entity);
	void deleteById(Integer id);

	/**
	 * 2021年08月19日17:19:38
	 *
	 * 所以不能有2个一样名字的，overload,重载是不行的，会以 latest 的为准。其他的会报错
	 */
	UserEntity getById(@Param("id") Integer id);
	UserEntity getById(@Param("id") Integer id, @Param("age")  Integer age);

	List<UserEntity> listByQuery(UserQuery query);
}
