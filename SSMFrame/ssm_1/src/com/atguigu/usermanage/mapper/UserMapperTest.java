package com.atguigu.usermanage.mapper;

import com.atguigu.usermanage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @author erdong
 * @create 2019-08-27 20:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml"})
public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void queryUserById() {
        Long id = 8l;
        User user = this.userMapper.queryUserById(id);
        System.out.println("根据用户id:" + id + "查询出的用户信息：" + user);
    }

    @Test
    public void updateUserById() {
        Long id = 8l;
        User user = this.userMapper.queryUserById(id);
        System.out.println("=========================修改前=============================");
        System.out.println("根据用户id:" + id + "查询出的用户信息：" + user);
        user.setUserName("千里香~");
        int i = this.userMapper.updateUserById(user);
        System.out.println("执行成功 " + i + "条修改");
        System.out.println("=========================修改后=============================");
        user = this.userMapper.queryUserById(id);
        System.out.println("根据用户id:" + id + "查询出的用户信息：" + user);
    }

    @Test
    public void save() {
        User user = new User(null, "唐三", "898988", "二东", 18, 1, new Date(), null, null);
        int i = userMapper.saveUser(user);
        System.out.println("执行成功 " + i + "条");
        Long id = 17l;
        user = this.userMapper.queryUserById(id);
        System.out.println("根据用户id:" + id + "查询出的用户信息：" + user);
    }

    @Test
    public void deleteUserById() {
        Long id = 17l;
        int i = this.userMapper.deleteUserById(id);
        System.out.println("执行成功" + i + "条");
    }

    @Test
    public void queryAllUserInfo() {
        List<User> users = this.userMapper.queryAllUserInfo();
        System.out.println("查询所有的用户信息:" + Arrays.asList(users) + "/br");
        System.out.println("查询所有的用户信息:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryAllUserResultMap() {
        List<User> maps = this.userMapper.queryAllUserResultListUser();

        for (User map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void queryTotal() {
        Long aLong = this.userMapper.queryTotal();
        System.out.println("目前的条数总共有：" + aLong);
    }

    @Test
    public void addUser() {
        User user1 = new User(null, "唐三", "898988", "二东", 18, 1, new Date(), null, null);
        User user2 = new User(null, "小三", "898988", "二东", 18, 1, new Date(), null, null);
        int i = userMapper.addUser(user1);
        int i1 = userMapper.addUser(user2);
        i = i + i1;
        List<User> users = userMapper.queryAllUserInfo();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("执行成功 " + i + "条");
    }
}
