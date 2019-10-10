package com.atguigu.usermanage.service;

import com.atguigu.usermanage.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-28 8:08
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    public Map<String, Object> queryUsers();

    /**
     * 新增2个用户，要成功都成功，要失败都失败
     *
     * @param user1
     * @param user2
     * @return
     */
    public Integer addUser(User user1, User user2);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public Boolean saveUser(User user);

    /**
     * 编辑用户
     *
     * @param user
     * @return
     */
    public Boolean editUser(User user);

    /**
     * 批量删除用户
     *
     * @param id
     * @return
     */
    public Boolean deleteUserByIds(String[] id);
}
