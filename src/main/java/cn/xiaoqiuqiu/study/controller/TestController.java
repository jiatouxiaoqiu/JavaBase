package cn.xiaoqiuqiu.study.controller;

import cn.xiaoqiuqiu.study.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String getByName(@RequestParam Integer id) {
        int Id;
//        boolean b = sService.ExistsById(id);
        if (false) {
            return "The   id is exist.";
        }
        return "user id is not exist.";
    }

    @GetMapping("/ab")
    public UserEntity get4() {
        return new UserEntity();
    }
}
