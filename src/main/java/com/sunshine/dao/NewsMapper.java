package com.sunshine.dao;

import com.sunshine.entity.News;
import com.sunshine.entity.NewsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByExample(NewsExample example);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    int updateByExampleSelective(@Param("record") News record, @Param("example") NewsExample example);

    int updateByExample(@Param("record") News record, @Param("example") NewsExample example);
}