package com.sunshine.dao;


import com.sunshine.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapperEx {

    User usersLogin(@Param("account") String account);

    int createUser(@Param("user") User user);

    /**
     * 用户一览
     * @return
     */
    List<User> userList();

    int updateUser(@Param("user") User user);

    int deleteUser(@Param("id") String id);

    String detailUser(@Param("Id") int Id);

    //shiro
    User selectAllByName(@Param("userName") String userName);


}
