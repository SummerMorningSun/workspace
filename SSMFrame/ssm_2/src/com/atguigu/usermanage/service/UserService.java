package com.atguigu.usermanage.service;

import com.atguigu.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * UserService 接口
 *
 * @author erdong
 * @create 2019-08-30 7:47
 */
public interface UserService {
    /**
     * 查询所有用户方法
     *
     * @return
     */
    Map<String, Object> queryUsers();

    /**
     * 新增用户方法
     *
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     * 修改用户方法
     *
     * @param user
     * @return
     */
    Boolean updateUsers(User user);

    /**
     * 删除多个用户
     *
     * @param id
     * @return
     */
    Boolean deleteUserByIds(@Param("ids") String[] id);

    /**
     * @param id
     * @return
     */
    User queryUserById(Long id);

    /**
     * 删除用户（Resutful）
     *
     * @param id
     * @return
     */
    Boolean deleteUserById(Long id);
}
