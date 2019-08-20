package com.sunshine.dao;

import com.sunshine.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapperEx {

    List<Role> findRoleByUid(@Param("id") int id);
}
