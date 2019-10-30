package com.blogger.dao.UserMapper;


import com.blogger.entity.UserEntity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapperEx {

    // 用户台账
    List<User> getUserList();

    // 用户创建
    int createUser(@Param("user") User user);

    // 用户更新
    int updateUser(@Param("user") User user);

    // 用户删除
    int deleteUser(@Param("userId") int id);

    // 用户详情
    User detailsUser(@Param("userId") int Id);




    User usersLogin(@Param("account") String account);

    //shiro
    User selectAllByName(@Param("userName") String userName);
}
