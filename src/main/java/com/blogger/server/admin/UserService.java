package com.blogger.server.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.entity.admin.User;
import com.blogger.entity.article.Article;

import java.util.List;

/**
 * 用户管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 */
public interface UserService {

    /**
     * 用户台账
     * @return
     */
    Page<User> getUserList(Page<User> page);

    /**
     * 用户保存
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 用户删除
     * @param userId
     * @return
     */
    int deleteUser(int userId);

    /**
     * 用户详情
     * @param userId
     * @return
     */
    User detailsUser(int userId);



    User usersLogin(String account);

    int createUser(User user);

}
