package com.atguigu.usermanage.service.impl;

import com.atguigu.usermanage.mapper.UserMapper;
import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-28 8:09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 默认查询所有用户信息功能
     *
     * @return
     */
    public Map<String, Object> queryUsers() {
        Map<String, Object> maps = new HashMap<>();
        // 所有的User信息
        List<User> users = userMapper.queryAllUserResultListUser();
        // 总共User用户的数据条数
        Long total = userMapper.queryTotal();
        maps.put("rows", users);
        maps.put("total", total);

        return maps;
    }

    /**
     * 新增两个客户 （用于测试的并没有在前端实现）
     *
     * @param user1
     * @param user2
     * @return
     */
    @Override
    public Integer addUser(User user1, User user2) {
        int a = userMapper.addUser(user1);
        int b = userMapper.addUser(user2);
        int i = a + b;
        return i;
    }

    /**
     * 新增用户功能
     *
     * @param user
     * @return
     */
    @Override
    public Boolean saveUser(User user) {
        int i = userMapper.saveUser(user);
        return i == 1 ? true : false;
    }

    /**
     * 编辑用户功能
     *
     * @param user
     * @return
     */
    @Override
    public Boolean editUser(User user) {
        int i = userMapper.updateUserById(user);
        return i == 1 ? true : false;
    }

    /**
     * 批量删除用户功能
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteUserByIds(String[] id) {
        int i = userMapper.deleteUserByIds(id);
        return i > 0 ? true : false;
    }
}
