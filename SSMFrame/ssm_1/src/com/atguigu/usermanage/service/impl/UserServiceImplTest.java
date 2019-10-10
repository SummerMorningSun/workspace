package com.atguigu.usermanage.service.impl;

import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-28 9:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml"})
public class UserServiceImplTest {

    // 引入逻辑层
    @Autowired
    private UserService userService;

    @Test
    public void queryUsersTest() {
        Map<String, Object> map = userService.queryUsers();
        System.out.println("===================================================");
        System.out.println(map);
    }

    @Test
    public void addUserTest() {
        User user1 = new User();
        User user2 = new User();
        user1.setUserName("wenwen");
        user1.setPassword("wenwen123");
        user2.setUserName("tanglei");
        user2.setPassword("tanglei123");

        Integer i = userService.addUser(user1, user2);
        System.out.println("执行成功：" + i + "条数据");
    }

    @Test
    public void editUserTest() {
        User user = new User(19l, "唐三2", "898988", "二东", 18, 1, new Date(), new Date(), new Date());
        Boolean editUser = userService.editUser(user);
        System.out.println("修改是否：" + editUser);

    }
}
