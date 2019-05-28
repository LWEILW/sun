package com.sunshine.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunshine.entity.News;
import com.sunshine.entity.User;
import com.sunshine.server.NewsServer;
import com.sunshine.server.UserServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "[APP-测试接口]-FrontExaminationReportController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;

    @Autowired
    private NewsServer newsServer;

//    //首页跳转类
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }


//    @PostMapping("/login")
//    @ResponseBody
//    public Result login(HttpSession session, User user) {
//        //模拟登录
//        if ("admin".equals(user.getUserName()) && "123456".equals(user.getPassword())){
//            session.setAttribute("user", user);
//            return new Result(Result.SUCCESS, "登录成功！");
//        }
//        return new Result(Result.FAILED, "登录失败，请核对用户名密码后重试！");
//    }
//
//    @PostMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute("user");
//        return "/login";
//    }

//    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
////    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
//    @GetMapping("/userDetail")
//    public void userDetail(@PathVariable("Id") int id) {
//        // Map map= JSONObject.parseObject(data, Map.class);
//
//        ItemIntroduce name = itemServer.getItemById(id);
//        System.out.println(name);
//        System.out.println("I can write codeaa!");
////        return "I can write codeaa!";
//    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/userDetaill")
    public String userDetaill() {
        String name = userServer.userName(1);
        System.out.println("String");
        return name;
    }


    @GetMapping("/newsList")
    public List<News> newsList() {
//        JSONObject js = JSONObject.parseObject(data, JSONObject.class);
        News news = new News();
        List<News> newsList = newsServer.newsList();

        System.out.println("newsList");
        return newsList;
    }

    @GetMapping("/getNews/{id}")
    public String getNews(@PathVariable("id") int id) {
        String name = userServer.userName(id);
        System.out.println(name);
        return name;
    }
}
