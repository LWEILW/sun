package com.blogger.server.RoleService;

import com.blogger.entity.RoleEntity.Role;

import java.util.List;

public interface RoleService {

    // 角色台账
    List<Role> getRoleList();

    // 角色保存
    boolean saveRole(Role role);


    // 角色删除
    int deleteRole(int roleId);


    // 角色详情
    Role detailsRole(int roleId);

}
