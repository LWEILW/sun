package com.sunshine.dao;

import com.sunshine.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapperEx {

    List<News> newsList();
}
