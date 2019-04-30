package com.sunshine.controller;

import com.sunshine.entity.Item;
import com.sunshine.entity.ItemIntroduce;
import com.sunshine.server.ItemServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ItemServer itemServer;

    @GetMapping("/userDetail")
    public void userDetail()  {
        ItemIntroduce name = itemServer.getItemById(1);
        System.out.println(name);
        System.out.println("I can write code!");
    }

}
