package com.sunshine.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapperEx {

    String userName(@Param("Id") Integer Id);
}
