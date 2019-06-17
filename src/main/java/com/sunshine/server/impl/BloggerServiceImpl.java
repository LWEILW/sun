package com.sunshine.server.impl;

import com.sunshine.dao.BloggerMapperEx;
import com.sunshine.entity.Blogger;
import com.sunshine.server.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerMapperEx bloggerMapperEx;


    @Override
    public List<Blogger> bloggerList() {
        return bloggerMapperEx.bloggerList();
    }

    @Override
    public int createBlogger(Blogger blogger) {
        return bloggerMapperEx.createBlogger(blogger);
    }

    @Override
    public int deleteBlogger(String id) {
        return bloggerMapperEx.deleteBlogger(id);
    }

    @Override
    public int updateBlogger(Blogger blogger) {
        return bloggerMapperEx.updateBlogger(blogger);
    }

    @Override
    public Blogger getBlogger(String id) {
        return bloggerMapperEx.getBlogger(id);
    }

    @Override
    public  List<Blogger> getBloggerByParam(String searchParam){
        return bloggerMapperEx.getBloggerByParam(searchParam);
    }
}
