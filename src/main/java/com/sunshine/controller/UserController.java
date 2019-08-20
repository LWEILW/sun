package com.sunshine.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunshine.entity.User;
import com.sunshine.server.UserService;
import com.sunshine.util.Utils;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "[APP-测试接口]-FrontExaminationReportController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


//    /**
//     * 用户注册
//     *
//     * @param data
//     * @return
//     */
//    @PostMapping("/usersRegister")
//    public int usersRegister(@RequestBody String data) {
//        JSONObject obj = JSONObject.parseObject(data);
//        String account = obj.getString("account");
//        int password = obj.getInteger("password");
//
//        User users = new User();
//        users.setId("user" + Utils.getUUID());
//        users.setAccount(account);
//        users.setPassword(password);
////        user.setToken();
//        return userService.createUser(users);
//    }
//
//    /**
//     * 用户登录验证
//     *
//     * @param data
//     * @return
//     */
//    @PostMapping("/usersLogin")
//    public Result usersLogin(@RequestBody String data) {
//        JSONObject obj = JSONObject.parseObject(data);
//        String account = obj.getString("account");
//        int password = obj.getInteger("password");
//
//        Result result = new Result();
//        // 根据账户查询用户信息
//        User user = userService.usersLogin(account);
//        if (user != null) {
//            // 该账户存在于数据库
//            if (user.getPassword()==password) {
//                //"密码正确，登录成功"
//                result.setMsg("密码正确,登录成功");
//                result.setFlag(true);
//            } else {
//                //"密码错误，登录失败"
//                result.setMsg("密码错误，登录失败");
//                result.setFlag(false);
//            }
//        } else {
//            // 登录失败,该账户不存在
//            result.setMsg("登录失败,该账户不存在");
//            result.setFlag(false);
//        }
//        return result;
//    }

    /**
     * 用户列表
     * @return
     */
    @GetMapping("userList")
    public List<User> userList() {
        List<User> userList = userService.userList();
        return userList;
    }

    /**
     * 更新用户
     * @param data
     * @return
     */
    @PostMapping("updateUser")
    public int updateUser(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        User users = JSON.parseObject(obj.getString("user"), User.class);

        return userService.updateUser(users);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("deleteUser/{id}")
    public int deleteUser(@PathVariable String id ){
        return userService.deleteUser(id);
    }


    /**
     * 用户详情
     * @return
     */
    @GetMapping("/detailUser/{id}")
    public String detailUser(@PathVariable("id") int id) {
        String name = userService.detailUser(id);
        System.out.println(name);
        return name;
    }

}
