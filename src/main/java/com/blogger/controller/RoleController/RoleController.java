package com.blogger.controller.RoleController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.entity.UserEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    // 角色台账
    @PostMapping("getRoleList")
    public List<Role> getRoleList() {
        List<Role> roleList = roleService.getRoleList();
        return roleList;
    }

    // 角色保存
    @PostMapping("saveRole")
    public String saveRole(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        Role user = JSON.parseObject(data, Role.class);

        boolean succ = userService.saveRole(user);
        if (succ) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }

    // 角色删除
    @GetMapping("deleteRole/{userId}")
    public int deleteRole(@PathVariable int userId) {

        return userService.deleteRole(userId);
    }


    // 角色详情
    @GetMapping("/detailsRole/{RoleId}")
    public Role detailsRole(@PathVariable("userId") int userId) {
        Role user = userService.detailsRole(userId);
        return user;
    }
}
