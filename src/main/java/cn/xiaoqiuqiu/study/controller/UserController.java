package cn.xiaoqiuqiu.study.controller;

import cn.xiaoqiuqiu.study.entity.UserEntity;
import cn.xiaoqiuqiu.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

//    @ApiOperation("Add/Edit User")
    @PostMapping("/add")
    public UserEntity add(@RequestBody  UserEntity user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        return user;
    }

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable Long id) {
        return userMapper.selectById(id);
    }

    @GetMapping("/a")
    public UserEntity get2() {
        return new UserEntity();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public UserEntity get3() {
        return new UserEntity();
    }

}
