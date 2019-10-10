package com.atguigu.usermanage.test;

import com.atguigu.usermanage.dao.UserDao;
import com.atguigu.usermanage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author erdong
 * @create 2019-08-29 23:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    /*@Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userDao = context.getBean(UserDao.class);
    }*/


    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(1L);
        System.out.println(user);
    }


}
