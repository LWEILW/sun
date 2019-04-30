package com.sunshine.dao;


import com.sunshine.entity.ItemIntroduce;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemMapperEx {

    ItemIntroduce getItemById(@Param("Id") Integer Id);
}
