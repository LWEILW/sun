package com.blogger.dao.PermissionMapper;

import com.blogger.entity.PermissionEntity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapperEx {
    List<Permission> findPermissionByUid(@Param("id") int id);
}
