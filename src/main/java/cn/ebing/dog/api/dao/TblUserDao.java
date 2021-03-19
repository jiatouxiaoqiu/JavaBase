package cn.ebing.dog.api.dao;

import cn.ebing.dog.api.entity.TblUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(TblUser)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-19 16:48:06
 */
public interface TblUserDao {

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  TblUser queryById(Object id);

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<TblUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param tblUser 实例对象
   * @return 对象列表
   */
  List<TblUser> queryAll(TblUser tblUser);

  /**
   * 新增数据
   *
   * @param tblUser 实例对象
   * @return 影响行数
   */
  int insert(TblUser tblUser);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<TblUser> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<TblUser> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<TblUser> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<TblUser> entities);

  /**
   * 修改数据
   *
   * @param tblUser 实例对象
   * @return 影响行数
   */
  int update(TblUser tblUser);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 影响行数
   */
  int deleteById(Object id);
}
