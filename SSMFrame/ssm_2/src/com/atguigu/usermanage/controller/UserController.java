package com.atguigu.usermanage.controller;

import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户请求控制层
 *
 * @author erdong
 * @create 2019-08-29 20:37
 */
@RequestMapping("user") // 设置统一的映射请求头
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 员工首页
     *
     * @return
     */
    @RequestMapping("users")
    public String toUsers() {
        return "users";
    }

    /**
     * 员工首页查询所有员工功能
     *
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryAllUserCon() {
        return userService.queryUsers();
    }

    /**
     * 新增员工功能
     * 请求路径 /user/page/save
     * 方法返回值：{status:200}
     * 参数：User对象
     *
     * @param user
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> addUsers(@Valid User user, BindingResult result) {
        Map<String, Object> map = new HashMap<>();

        // 如果有异常错误 及时处理
        if (result.hasErrors()) {
            map.put("status", 500);
            return map;
        }

        // 调用逻辑处理层 service
        Boolean b = userService.addUser(user);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

    /**
     * 修改用户信息功能
     * 请求路径 /user/page/edit
     * 方法返回值：{status:200}
     * 参数：User对象
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("edit")
    @ResponseBody
    public Map<String, Object> editUsers(@Valid User user, BindingResult result) {
        Map<String, Object> map = new HashMap<>();

        // 如果有异常错误，及时处理
        if (result.hasErrors()) {
            map.put("status", 500);
            return map;
        }

        // 调用修改用户方法
        Boolean b = userService.updateUsers(user);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteUsers(@RequestParam("ids") String[] id) {
        Map<String, Object> map = new HashMap<>();

        Boolean b = userService.deleteUserByIds(id);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

}
