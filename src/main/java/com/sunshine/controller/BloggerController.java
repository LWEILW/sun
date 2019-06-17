package com.sunshine.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunshine.entity.Blogger;
import com.sunshine.server.BloggerService;
import com.sunshine.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @GetMapping("/bloggerList")
    public List<Blogger> bloggerList() {
        return bloggerService.bloggerList();
    }

    @PostMapping("/createBlogger")
    public int createBlogger(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        Blogger blogger = JSON.parseObject(obj.getString("blogger"), Blogger.class);
        blogger.setId("Blogger" + Utils.getUUID());
        return bloggerService.createBlogger(blogger);
    }

    @GetMapping("/deleteBlogger/{id}")
    public int deleteBlogger(@PathVariable String id) {
        return bloggerService.deleteBlogger(id);
    }

    @PostMapping("/updateBlogger")
    public int updateBlogger(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        Blogger blogger = JSON.parseObject(obj.getString("blogger"), Blogger.class);
        return bloggerService.updateBlogger(blogger);
    }


    @GetMapping("/getBlogger/{id}")
    public Blogger getBlogger(@PathVariable String id) {
        Blogger blogger = bloggerService.getBlogger(id);
        return blogger;
    }

    @PostMapping("/getBloggerByParam")
    public List<Blogger> getBloggerByParam(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String searchParam = obj.getString("searchParam");
        List<Blogger> bloggerList = bloggerService.getBloggerByParam(searchParam);
        System.out.println("1");
        return bloggerList;
    }


}
