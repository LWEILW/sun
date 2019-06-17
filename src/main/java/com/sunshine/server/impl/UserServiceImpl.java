package com.sunshine.server.impl;

import com.sunshine.dao.UserMapperEx;
import com.sunshine.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperEx userMapperEx;


    @Override
    public String userName(int Id) {
        return userMapperEx.userName(Id);
    }
}
