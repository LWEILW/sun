package com.sunshine.dao;

import com.sunshine.entity.ItemIntroduce;
import com.sunshine.entity.ItemIntroduceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemIntroduceMapper {
    int countByExample(ItemIntroduceExample example);

    int deleteByExample(ItemIntroduceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemIntroduce record);

    int insertSelective(ItemIntroduce record);

    List<ItemIntroduce> selectByExample(ItemIntroduceExample example);

    ItemIntroduce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemIntroduce record, @Param("example") ItemIntroduceExample example);

    int updateByExample(@Param("record") ItemIntroduce record, @Param("example") ItemIntroduceExample example);

    int updateByPrimaryKeySelective(ItemIntroduce record);

    int updateByPrimaryKey(ItemIntroduce record);
}