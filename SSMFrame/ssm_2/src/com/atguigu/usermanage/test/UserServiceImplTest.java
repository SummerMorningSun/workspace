package com.atguigu.usermanage.test;

import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-30 8:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryUser() {
        Map<String, Object> map = userService.queryUsers();

        List<User> rows = (List<User>) map.get("rows");
        Long total = (Long) map.get("total");

        for (User row : rows) {
            System.out.println(row);
        }

        System.out.println(total);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("erdongzi");
        user.setPassword("erdongzi");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setName("二东子");
        user.setSex(1);
        user.setUpdated(new Date());
        Boolean b = userService.addUser(user);
        System.out.println("新增:"+b);
    }
}
