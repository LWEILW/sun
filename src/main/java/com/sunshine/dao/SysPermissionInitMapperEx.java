package com.sunshine.dao;

import com.sunshine.entity.SysPermissionInit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionInitMapperEx {

    List<SysPermissionInit> selectAll();
}
