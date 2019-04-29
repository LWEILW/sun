package com.sunshine.dao;

import com.sunshine.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemMapperEx {

    Item getItemById(@Param("Id") Integer Id);
}
