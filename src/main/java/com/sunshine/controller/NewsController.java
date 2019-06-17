package com.sunshine.controller;

import com.sunshine.entity.News;
import com.sunshine.server.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/newsList")
    public List<News> newsList() {
        List<News> newsList = newsService.newsList();
        System.out.println("newsList");
        return newsList;
    }
}
