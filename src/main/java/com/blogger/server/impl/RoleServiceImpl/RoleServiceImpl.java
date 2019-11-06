package com.blogger.server.impl.RoleServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.blogger.dao.RoleMapper.RoleMapperEx;
import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.entity.UserEntity.User;
import com.blogger.server.RoleService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapperEx roleMapperEx;

    // 角色台账
    @Override
    public List<Role> getRoleList() {
        return roleMapperEx.getRoleList();
    }

    // 角色保存
    @Override
    public boolean saveRole(Role role) {
        int succ = 0;
        if (role.getRoleId() != null && role.getRoleId() != "") {
            // ID不为空，更新操作
            succ = roleMapperEx.updateRole(role);
        } else {
            // ID为空，创建操作
            succ = roleMapperEx.createRole(role);
        }

        if (succ != 1) {
            return false;
        }
        return true;
    }


    // 角色删除
    @Override
    public int deleteRole(int roleId) {
        return roleMapperEx.deleteRole(roleId);
    }


    // 角色详情
    @Override
    public Role detailsRole(int roleId) {
        return roleMapperEx.detailsRole(roleId);
    }

    // 人员维护台账
    @Override
    public List<User> getUserListByRoleId(int roleId) {
        return roleMapperEx.getUserListByRoleId(roleId);
    }

    // 人员维护添加
    @Override
    public boolean addUserByRoleId(JSONObject obj) {
        int roleId = obj.getInteger("roleId");
        int userId = obj.getInteger("userId");

        int count = roleMapperEx.addUserByRoleId(roleId, userId);
        if (count != 1) {
            return false;
        }
        return true;
    }


    // 权限维护台账
    @Override
    public List<Permission> getPermissionListByRoleId(int roleId) {
        return roleMapperEx.getPermissionListByRoleId(roleId);
    }

    // 权限维护添加
    @Override
    public boolean addPermissionByRoleId(JSONObject obj) {
        int roleId = obj.getInteger("roleId");
        int permissionId = obj.getInteger("permissionId");

        int count = roleMapperEx.addPermissionByRoleId(roleId, permissionId);
        if (count != 1) {
            return false;
        }
        return true;
    }
}
