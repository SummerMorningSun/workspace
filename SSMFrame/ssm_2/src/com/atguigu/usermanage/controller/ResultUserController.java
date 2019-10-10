package com.atguigu.usermanage.controller;

import com.atguigu.usermanage.pojo.User;
import com.atguigu.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author erdong
 * @create 2019-08-30 21:12
 */
@Controller
@RequestMapping("rest/user")
public class ResultUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> queryUserAll() {

        Map<String, Object> map = this.userService.queryUsers();
        if (CollectionUtils.isEmpty(map)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(map);
    }

    @GetMapping("{id}")
    //@ResponseBody
    public ResponseEntity<User> QueryUserById(@PathVariable("id") Long id) {

        // 参数列表不合法，响应400
        if (id == null || id.longValue() <= 0) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //响应数据用body,
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return ResponseEntity.badRequest().build();
        }
        // int i = 1/0;
        User user = this.userService.queryUserById(id);
        // 查询结果为空，响应404
        if (user == null) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
        // 正常响应200
        //return ResponseEntity.status(HttpStatus.OK).body(user);
        //return new ResponseEntity<User>(user,HttpStatus.OK);
        return ResponseEntity.ok(user);
        // 服务端异常，响应500
        // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(User user) {
        if (user == null || StringUtils.isEmpty(user.getUserName())) {
            return ResponseEntity.badRequest().build();
        }
        Boolean flag = this.userService.addUser(user);
        if (!flag) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateuser(User user) {

        if (user == null || user.getId() == null) {
            return ResponseEntity.badRequest().build(); // 400
        }
        // 调用修改方法
        Boolean flag = this.userService.updateUsers(user);
        if (!flag) { // 400
            return ResponseEntity.badRequest().build();
        }
        // 跟新成功 204
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("ids") String[] ids) {
        if (StringUtils.isEmpty(ids)) {
            return ResponseEntity.badRequest().build(); // 400
        }
        // 调用修改方法
        Boolean flag = this.userService.deleteUserByIds(ids);
        if (!flag) { // 400
            return ResponseEntity.badRequest().build();
        }
        // 跟新成功 204
        return ResponseEntity.noContent().build();
    }

}
