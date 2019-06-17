package com.sunshine.server;

import com.sunshine.entity.Blogger;

import java.util.List;

public interface BloggerService {

    List<Blogger> bloggerList();

    int createBlogger(Blogger blogger);

    int deleteBlogger(String id);

    int updateBlogger(Blogger blogger);

    Blogger getBlogger(String id);

    List<Blogger> getBloggerByParam(String searchParam);

}
