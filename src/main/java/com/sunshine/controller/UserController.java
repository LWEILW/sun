package com.sunshine.controller;

import com.sunshine.entity.ItemIntroduce;
import com.sunshine.server.ItemServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "[APP-测试接口]-FrontExaminationReportController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ItemServer itemServer;

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

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/userDetail")
    public void userDetail() {
        ItemIntroduce name = itemServer.getItemById(1);
        System.out.println(name);
        System.out.println("I can write code!");
    }

}
