package com.sunshine.server.impl;

import com.sunshine.dao.UserMapperEx;
import com.sunshine.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServer")
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapperEx userMapperEx;


    @Override
    public String userName(Integer Id) {
        return userMapperEx.userName(Id);
    }
}
