package com.atguigu.usermanage.dao;

import com.atguigu.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao层接口
 *
 * @author erdong
 * @create 2019-08-29 22:47
 */
public interface UserDao {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据id查询用户信息
     *
     * @return
     */
    User queryUserById(Long id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> queryAllUser();

    /**
     * 查询所有用户总个数
     *
     * @return
     */
    Long queryAllUserCount();

    /**
     * 修改用户信息
     *
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 删除多个用户
     *
     * @param id
     * @return
     */
    int deleteUserByIds(@Param("ids") String[] id);

    /**
     * 根据id删除用户(Resultful)
     *
     * @return
     */
    int deleteUserById(Long id);
}
