package com.atguigu.usermanage.test;

import com.atguigu.usermanage.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-30 8:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml","classpath:spring/usermanage-servlet.xml"})
public class UserControllerTest {

    //@Resource(name = "userController")
    @Autowired
    private UserController userController;

    @Test
    public void queryAllUserCon() {
        Map<String, Object> map = userController.queryAllUserCon();
        System.out.println(map);
    }
}
