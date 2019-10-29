package com.blogger.controller.Model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.UserEntity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class model {


    // 模板台账
    @PostMapping("getModelList")
    public List<Model> getModelList() {
        List<Model> userList = modelService.getUserList();
        return userList;
    }

    // 角色保存
    @PostMapping("saveUser")
    public String saveUser(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        User user = JSON.parseObject(data, User.class);

        boolean succ = userService.saveUser(user);
        if (succ) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }

    // 角色删除
    @GetMapping("deleteUser/{userId}")
    public int deleteUser(@PathVariable int userId) {

        return userService.deleteUser(userId);
    }


    // 角色详情
    @GetMapping("/detailsUser/{userId}")
    public User detailsUser(@PathVariable("userId") int userId) {
        User user = userService.detailsUser(userId);
        return user;
    }
}
