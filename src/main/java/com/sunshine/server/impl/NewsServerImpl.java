package com.sunshine.server.impl;

import com.sunshine.dao.NewsMapperEx;
import com.sunshine.entity.News;
import com.sunshine.server.NewsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NewsServer")
public class NewsServerImpl implements NewsServer {

    @Autowired
    private NewsMapperEx newsMapperEx;


    @Override
    public List<News> newsList() {
        return newsMapperEx.newsList();
    }
}
