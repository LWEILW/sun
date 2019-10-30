package com.blogger.controller.RoleController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.server.RoleService.RoleService;
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
        Role role = JSON.parseObject(data, Role.class);

        boolean succ = roleService.saveRole(role);
        if (succ) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }

    // 角色删除
    @GetMapping("deleteRole/{roleId}")
    public int deleteRole(@PathVariable int roleId) {

        return roleService.deleteRole(roleId);
    }


    // 角色详情
    @GetMapping("/detailsRole/{roleId}")
    public Role detailsRole(@PathVariable("roleId") int roleId) {
        Role role = roleService.detailsRole(roleId);
        return role;
    }
}
