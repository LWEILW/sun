package com.sunshine.dao;

import com.sunshine.entity.Blogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BloggerMapperEx {

    List<Blogger> bloggerList();

    int createBlogger(@Param("blogger") Blogger blogger);

    int deleteBlogger(@Param("id") String id);

    int updateBlogger(@Param("blogger") Blogger blogger);

    Blogger getBlogger(@Param("id") String id);

    List<Blogger> getBloggerByParam(@Param("searchParam") String searchParam);
}
