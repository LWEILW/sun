package com.blogger.server.impl.RoleServiceImpl;

import com.blogger.dao.RoleMapper.RoleMapperEx;
import com.blogger.entity.RoleEntity.Role;
import com.blogger.server.RoleService.RoleService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
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
}
