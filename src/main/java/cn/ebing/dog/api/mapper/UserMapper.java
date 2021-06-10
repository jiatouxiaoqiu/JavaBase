package cn.ebing.dog.api.mapper;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

@Mapper
public interface UserMapper {
	SqlSessionFactoryBuilder

	int addOne(UserEntity entity);
	int updateOne(UserEntity entity);
	void deleteById(Integer id);
	UserEntity getById(Integer id);
	List<UserEntity> listByQuery(UserQuery query);
}
