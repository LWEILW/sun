package com.sunshine.server;

import com.sunshine.entity.User;

import java.util.List;

public interface UserService {

    User usersLogin(String account);

    int createUser(User user);

    /**
     * 用户一览
     * @return
     */
    List<User> userList();

    int updateUser(User user);

    int deleteUser(String id);

    String detailUser(int Id);

}
