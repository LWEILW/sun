package com.sunshine.controller;

import com.sunshine.entity.Item;
import com.sunshine.entity.ItemIntroduce;
import com.sunshine.server.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ItemServer itemServer;

    //首页跳转类
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


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


    @GetMapping("/userDetail")
    public void userDetail() {
        ItemIntroduce name = itemServer.getItemById(1);
        System.out.println(name);
        System.out.println("I can write code!");
    }

}
