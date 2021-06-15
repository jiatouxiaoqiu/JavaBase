package cn.ebing.dog.api.mapper;

import cn.ebing.dog.api.domain.entity.KeyCustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeyCustomerMapper {
	void insertMany(@Param("entities") List<KeyCustomerEntity> entities);
	void updateMany(@Param("entities") List<KeyCustomerEntity> entities);
}
