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
 * @author erdong
 * @create 2019-08-27 18:36
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	// 添加一行注释，并提交到本地仓库，且后提交到远程仓库中去，
	
    // 引入逻辑服务层 Service
    @Autowired
    private UserService userService;

    /**
     * 映射测试 跳转
     *
     * @return
     */
    @RequestMapping("users")
    public String toUsers() {
        return "users";
    }

    /**
     * 查询所有用户信息功能
     *
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryUsersss() {
        Map<String, Object> map = userService.queryUsers();
        return map;
    }

    /**
     * 新增用户功能
     *
     * @param user
     * @param result
     * @return
     * @throws Exception
     */
    // saveUser优化版
    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> saveUser(@Valid User user, BindingResult result) throws Exception {
        Map<String, Object> map = new HashMap<>();

        // 如果有异常错误
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            map.put("status", 500);
            return map;
        }
        // 调用userService新增方法
        Boolean b = this.userService.saveUser(user);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }

        return map;
    }
    /*@RequestMapping("save")
    @ResponseBody
    public Map<String, Object> saveUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        Boolean b = userService.saveUser(user);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }*/

    @RequestMapping("edit")
    @ResponseBody
    public Map<String, Object> editUsers(@Valid User user, BindingResult result) {
        Map<String, Object> map = new HashMap<>();
        // 安全验证，如果有异常
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            map.put("status", 500);
            return map;
        }
        // 调用编辑用户方法
        Boolean b = userService.editUser(user);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteUserByIds(@RequestParam("ids") String[] ids) {
        Map<String, Object> map = new HashMap<>();
        // 调用服务层userService新增方法
        Boolean b = this.userService.deleteUserByIds(ids);
        if (b) {
            map.put("status", 200);
        } else {
            map.put("status", 500);
        }
        return map;
    }

}
