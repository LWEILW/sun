package com.sunshine.controller;

import com.sunshine.server.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@Api(value = "[APP-测试接口]-FrontExaminationReportController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/userDetaill")
    public String userDetaill() {
        String name = userService.userName(1);
        System.out.println("String");
        return name;
    }

    @GetMapping("/getNews/{id}")
    public String getNews(@PathVariable("id") int id) {
        String name = userService.userName(id);
        System.out.println(name);
        return name;
    }

}
