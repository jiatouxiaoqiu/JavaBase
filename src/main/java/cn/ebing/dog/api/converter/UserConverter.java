package cn.ebing.dog.api.converter;

import cn.ebing.dog.api.domain.entity.UserEntity;
import cn.ebing.dog.api.domain.request.UserRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author qhb
 * @Date 2021/8/23 3:46 下午
 * @Version 1.0
 */
@Component
public class UserConverter {

    public List<UserEntity> request2entities(List<UserRequest> list) {
        return list.stream().map((request) -> {
            UserEntity entity = new UserEntity();
            entity.setAge(request.getAge());
            entity.setName(request.getName());
            entity.setSex(request.getSex());
            return entity;
        }).collect(Collectors.toList());
    }

}
