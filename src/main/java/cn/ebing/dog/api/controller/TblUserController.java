//package cn.ebing.dog.api.controller;
//
//import cn.ebing.dog.api.entity.TblUser;
//import cn.ebing.dog.api.service.TblUserService;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * 用户表(TblUser)表控制层
// *
// * @author makejava
// * @since 2021-03-19 16:48:16
// */
//@RestController
//@RequestMapping("tblUser")
//public class TblUserController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private TblUserService tblUserService;
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("selectOne")
//    public TblUser selectOne(Object id) {
//        return this.tblUserService.queryById(id);
//    }
//
//}
