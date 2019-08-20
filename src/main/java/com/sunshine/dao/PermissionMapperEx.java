package com.sunshine.dao;

import com.sunshine.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapperEx {
    List<Permission> findPermissionByUid(@Param("id") int id);
}
