package com.blogger.server.PermissionService;

import com.blogger.entity.PermissionEntity.Permission;

import java.util.List;

public interface PermissionService {

    // 权限台账
    List<Permission> getPermissionList();

    // 权限保存
    boolean savePermission(Permission permission);


    // 权限删除
    int deletePermission(int permissionId);

    // 权限详情
    Permission detailsPermission(int permissionId);
}
