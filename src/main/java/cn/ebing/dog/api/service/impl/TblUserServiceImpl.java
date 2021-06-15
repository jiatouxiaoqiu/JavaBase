//package cn.ebing.dog.api.service.impl;
//
//import cn.ebing.dog.api.entity.TblUser;
//import cn.ebing.dog.api.dao.TblUserDao;
//import cn.ebing.dog.api.service.TblUserService;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * 用户表(TblUser)表服务实现类
// *
// * @author makejava
// * @since 2021-03-19 16:48:16
// */
//@Service("tblUserService")
//public class TblUserServiceImpl implements TblUserService {
//  @Resource private TblUserDao tblUserDao;
//
//  /**
//   * 通过ID查询单条数据
//   *
//   * @param id 主键
//   * @return 实例对象
//   */
//  @Override
//  public TblUser queryById(Object id) {
//    return this.tblUserDao.queryById(id);
//  }
//
//  /**
//   * 查询多条数据
//   *
//   * @param offset 查询起始位置
//   * @param limit 查询条数
//   * @return 对象列表
//   */
//  @Override
//  public List<TblUser> queryAllByLimit(int offset, int limit) {
//    return this.tblUserDao.queryAllByLimit(offset, limit);
//  }
//
//  /**
//   * 新增数据
//   *
//   * @param tblUser 实例对象
//   * @return 实例对象
//   */
//  @Override
//  public TblUser insert(TblUser tblUser) {
//    this.tblUserDao.insert(tblUser);
//    return tblUser;
//  }
//
//  /**
//   * 修改数据
//   *
//   * @param tblUser 实例对象
//   * @return 实例对象
//   */
//  @Override
//  public TblUser update(TblUser tblUser) {
//    this.tblUserDao.update(tblUser);
//    return this.queryById(tblUser.getId());
//  }
//
//  /**
//   * 通过主键删除数据
//   *
//   * @param id 主键
//   * @return 是否成功
//   */
//  @Override
//  public boolean deleteById(Object id) {
//    return this.tblUserDao.deleteById(id) > 0;
//  }
//}
