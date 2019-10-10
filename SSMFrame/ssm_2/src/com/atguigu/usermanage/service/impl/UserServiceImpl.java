package com.atguigu.usermanage.service.impl;

import com.atguigu.usermanage.dao.UserDao;
import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserService接口实现类UserServiceImpl
 *
 * @author erdong
 * @create 2019-08-30 7:50
 */
@Service
public class UserServiceImpl implements UserService {

    // 引入UserDao层
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户方法
     *
     * @param user
     * @return
     */
    @Override
    public Boolean addUser(User user) {
        return userDao.addUser(user) == 1;
    }

    /**
     * 查询所有用户方法
     *
     * @return
     */
    @Override
    public Map<String, Object> queryUsers() {
        Map<String, Object> map = new HashMap<>();

        map.put("rows", userDao.queryAllUser());
        map.put("total", userDao.queryAllUserCount());

        return map;
    }

    /**
     * 修改用户方法
     *
     * @param user
     * @return
     */
    @Override
    public Boolean updateUsers(User user) {
        return userDao.updateUserInfo(user) == 1;
    }

    /**
     * 删除多个用户方法
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteUserByIds(String[] id) {
        return userDao.deleteUserByIds(id) > 0;
    }

    /**
     * 根据id查询用户信息方法
     *
     * @param id
     * @return
     */
    @Override
    public User queryUserById(Long id) {
        return userDao.queryUserById(id);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id) == 1;
    }
}
