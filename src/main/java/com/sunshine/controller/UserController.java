package com.sunshine.controller;

import com.sunshine.entity.Item;
import com.sunshine.server.ItemServer;
import com.sunshine.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServer userServer;

    @Autowired
    private ItemServer itemServer;

    @GetMapping("/userDetail")
    public void userDetail()  {
        Item name = itemServer.getItemById(1);
        String name1 = userServer.userName(1);
        System.out.println(name);
        System.out.println(name1);
        System.out.println("I can write code!");
    }

}
