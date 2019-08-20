package com.sunshine.server.impl;

import com.sunshine.dao.UserMapperEx;
import com.sunshine.entity.User;
import com.sunshine.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperEx userMapperEx;


    @Override
    public User usersLogin(String account) {
        return userMapperEx.usersLogin(account);
    }

    @Override
    public int createUser(User user) {
        return userMapperEx.createUser(user);
    }

    @Override
    public List<User> userList() {
        return userMapperEx.userList();
    }

    @Override
    public int updateUser(User user) {
        return userMapperEx.updateUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapperEx.deleteUser(id);
    }

    @Override
    public String detailUser(int Id) {
        return userMapperEx.detailUser(Id);
    }

}
