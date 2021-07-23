package cn.ebing.dog.api.mapper;

import cn.ebing.dog.api.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

//import cn.ebing.dog.api.domain.query.UserQuery;

@Mapper
public interface UserMapper {
	int addOne(UserEntity entity);
	int updateOne(UserEntity entity);
	void deleteById(Integer id);
	UserEntity getById(Integer id);
//	List<UserEntity> listByQuery(UserQuery query);
}
