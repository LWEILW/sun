package com.blogger.server.impl.PermissionServiceImpl;

import com.blogger.dao.PermissionMapper.PermissionMapperEx;
import com.blogger.entity.PermissionEntity.Permission;
import com.blogger.server.PermissionService.PermissionService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapperEx permissionMapperEx;

    // 权限台账
    @Override
    public List<Permission> getPermissionList() {
        return permissionMapperEx.getPermissionList();
    }

    // 权限保存
    @Override
    public boolean savePermission(Permission permission) {
        int succ = 0;
        if (permission.getPermissionId() != null && permission.getPermissionId() != "") {
            // ID不为空，更新操作
            succ = permissionMapperEx.updatePermission(permission);
        } else {
            // ID为空，创建操作
            succ = permissionMapperEx.createPermission(permission);
        }

        if (succ != 1) {
            return false;
        }
        return true;
    }


    // 权限删除
    @Override
    public int deletePermission(int permissionId) {
        return permissionMapperEx.deletePermission(permissionId);
    }


    // 权限详情
    @Override
    public Permission detailsPermission(int permissionId) {

        return permissionMapperEx.detailsPermission(permissionId);
    }
}
