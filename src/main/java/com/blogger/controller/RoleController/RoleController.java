package com.blogger.controller.RoleController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.entity.UserEntity.User;
import com.blogger.server.PermissionService.PermissionService;
import com.blogger.server.RoleService.RoleService;
import com.blogger.util.CodeMsg;
import com.blogger.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    // 角色台账
    @RequiresPermissions("角色一览")
    @PostMapping("getRoleList")
    public Result getRoleList() {
        List<Role> roleList = roleService.getRoleList();
        return Result.success(roleList);
    }

    // 角色保存
    @RequiresPermissions("role:saveRole")
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
    @RequiresPermissions("role:deleteRole")
    public boolean deleteRole(@PathVariable int roleId) {

        return roleService.deleteRole(roleId);
    }

    // 角色详情
    @RequiresPermissions("role:detailsRole")
    @GetMapping("/detailsRole/{roleId}")
    public Role detailsRole(@PathVariable("roleId") int roleId) {
        Role role = roleService.detailsRole(roleId);
        return role;
    }

    // 人员维护台账
    @RequiresPermissions("role:getUserListByRoleId")
    @GetMapping("getUserListByRoleId/{roleId}")
    public Result getUserListByRoleId(@PathVariable("roleId") int roleId) {

        List<User> userList = roleService.getUserListByRoleId(roleId);
        return Result.success(userList);
    }

    // 人员维护待添加人员台账
    @RequiresPermissions("role:getUserOthersByRoleId")
    @GetMapping("getUserOthersByRoleId/{roleId}")
    public Result getUserOthersByRoleId(@PathVariable("roleId") int roleId) {
        List<User> userList = roleService.getUserOthersByRoleId(roleId);
        return Result.success(userList);
    }

    // 人员维护添加
    @RequiresPermissions("role:addUserToRole")
    @PostMapping("addUserToRole")
    public Result addUserToRole(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        int roleId = obj.getInteger("changesRoleId");
        List<JSONObject> jsonObjectList = JSON.parseArray(obj.getString("userList"), JSONObject.class);
        boolean succ = roleService.addUserByRoleId(jsonObjectList, roleId);
        if (succ) {
            return Result.success("添加成功");
        } else {
            return Result.error(CodeMsg.INTER_ERROR, "添加失败");
        }
    }

    // 权限维护所有数据
    @RequiresPermissions("role:getPermissionAllListByRoleId")
    @GetMapping("getPermissionAllListByRoleId/{roleId}")
    public Result getPermissionAllListByRoleId(@PathVariable("roleId") int roleId) {
        List<JSONObject> permissionAllList = permissionService.getPermissionList();

        return Result.success(permissionAllList);
    }

    // 权限维护已选数据
    @RequiresPermissions("role:getPermissionChangeListByRoleId")
    @GetMapping("getPermissionChangeListByRoleId/{roleId}")
    public Result getPermissionChangeListByRoleId(@PathVariable("roleId") int roleId) {
        List<JSONObject> permissionList = roleService.getPermissionListByRoleId(roleId);

        return Result.success(permissionList);
    }


    // 权限维护添加
    @RequiresPermissions("role:addPermissionByRoleId")
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
