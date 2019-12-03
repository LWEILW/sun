package com.blogger.controller.RoleController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.entity.UserEntity.User;
import com.blogger.server.RoleService.RoleService;
import com.blogger.util.CodeMsg;
import com.blogger.util.Result;
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

    // 人员维护待添加人员台账
    @GetMapping("getUserOthersByRoleId/{roleId}")
    public Result getUserOthersByRoleId(@PathVariable("roleId") int roleId) {
        List<User> userList = roleService.getUserOthersByRoleId(roleId);
        return Result.success(userList);
    }

    // 人员维护添加
    @PostMapping("addUserToRole")
    public Result addUserToRole(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        int roleId = obj.getInteger("changesRoleId");
        List<JSONObject> jsonObjectList = JSON.parseArray(obj.getString("userList"), JSONObject.class);
        boolean succ = roleService.addUserByRoleId(jsonObjectList,roleId);
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

        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        for (Permission permission : permissionList) {
            if (permission.getLevelNo() == 1) {
                JSONObject obj = new JSONObject();
                obj.put("PermissionId", permission.getPermissionId());
                obj.put("label", permission.getFunctionName());
                obj.put("LevelNo", permission.getLevelNo());
                obj.put("ParentId", permission.getParentId());
                jsonObjects.add(obj);
            }
        }

        Map<String, List<JSONObject>> jsonObjectsChildren = new HashMap<>();
        for (JSONObject jsonObject : jsonObjects) {
            String FunName = jsonObject.getString("FunName");
            int PermissionId = jsonObject.getInteger("PermissionId");
            List<JSONObject> jsonObjects1 = new ArrayList<JSONObject>();
            for (Permission permission : permissionList) {
                int parentId = permission.getParentId();
                if (PermissionId == parentId) {
                    JSONObject one = new JSONObject();
                    one.put("label", permission.getFunctionName());
                    one.put("PermissionId", permission.getPermissionId());
                    jsonObjects1.add(one);

                }
            }
            jsonObject.put("children", jsonObjects1);
        }

        return Result.success(jsonObjects);
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
