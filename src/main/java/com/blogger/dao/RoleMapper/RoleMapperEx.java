package com.blogger.dao.RoleMapper;

import com.blogger.entity.RoleEntity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapperEx {

    // 角色台账
    List<Role> getRoleList();

    // 角色创建
    int createRole(@Param("role")  Role role);

    // 角色更新
    int updateRole(@Param("role")  Role role);

    // 角色删除
    int deleteRole(@Param("roleId")  int roleId);

    // 角色详情
    Role detailsRole(@Param("roleId")  int roleId);
}
