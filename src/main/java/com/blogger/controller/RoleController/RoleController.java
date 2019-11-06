package com.blogger.controller.RoleController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.entity.UserEntity.User;
import com.blogger.server.RoleService.RoleService;
import com.blogger.util.CodeMsg;
import com.blogger.util.Result;
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
    public Result getRoleList() {
        List<Role> roleList = roleService.getRoleList();
        return Result.success(roleList);
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

    // 人员维护台账
    @GetMapping("getUserListByRoleId/{roleId}")
    public Result getUserListByRoleId(@PathVariable("roleId") int roleId) {
        List<User> userList = roleService.getUserListByRoleId(roleId);
        return Result.success(userList);
    }

    // 人员维护添加
    @PostMapping("addUserByRoleId")
    public Result addUserByRoleId(@RequestBody String data) {
        JSONObject obj = JSON.parseObject(data);
        boolean succ = roleService.addUserByRoleId(obj);
        if (succ) {
            return Result.success("添加成功");
        } else {
            return Result.error(CodeMsg.INTER_ERROR, "添加失败");
        }
    }

    // 权限维护台账
    @GetMapping("getPermissionListByRoleId/{roleId}")
    public Result getPermissionListByRoleId(@PathVariable("roleId") int roleId) {
        List<Permission> permissionList = roleService.getPermissionListByRoleId(roleId);
        return Result.success(permissionList);
    }

    // 权限维护添加
    @PostMapping("addPermissionByRoleId")
    public Result addPermissionByRoleId(@RequestBody String data) {
        JSONObject obj = JSON.parseObject(data);
        boolean succ = roleService.addPermissionByRoleId(obj);
        if (succ) {
            return Result.success("添加成功");
        } else {
            return Result.error(CodeMsg.INTER_ERROR, "添加失败");
        }

    }
}
