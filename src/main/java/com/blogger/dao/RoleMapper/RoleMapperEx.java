package com.blogger.dao.RoleMapper;

import com.blogger.entity.RoleEntity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapperEx {

    List<Role> findRoleByUid(@Param("id") int id);
}
