package com.blogger.dao.PermissionMapper;

import com.blogger.entity.PermissionEntity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapperEx {

    // 权限台账
    List<Permission> getPermissionList();

    // 权限创建
    int createPermission(@Param("permission")  Permission permission);

    // 权限更新
    int updatePermission(@Param("permission")  Permission permission);

    // 权限删除
    int deletePermission(@Param("permissionId")  int permissionId);

    // 权限详情
    Permission detailsPermission(@Param("permissionId")  int permissionId);
}
