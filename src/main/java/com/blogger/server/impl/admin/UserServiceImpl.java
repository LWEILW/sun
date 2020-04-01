package com.blogger.server.impl.admin;

import com.baomidou.mybatisplus.plugins.Page;
import com.blogger.dao.admin.UserMapper;
import com.blogger.entity.admin.User;
import com.blogger.entity.article.Article;
import com.blogger.server.admin.UserService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 用户台账
     * @return
     */
    @Override
    public Page<User> getUserList(Page<User> page) {


        return page.setRecords(userMapper.getUserList(page));
    }

    /**
     * 用户保存
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        //密码加密
        RandomNumberGenerator saltGen = new SecureRandomNumberGenerator();
        String salt = saltGen.nextBytes().toString();
        Md5Hash md5Hash = new Md5Hash(user.getUserPassword(), salt, 2);
        user.setUserPassword(md5Hash.toString());
        user.setSalt(salt);

        int succ = 0;
        if (user.getUserId() != 0) {
            // ID不为空，更新操作
            succ = userMapper.updateUser(user);
        } else {
            // ID为空，创建操作
            succ = userMapper.createUser(user);
        }

        if (succ != 1) {
            return false;
        }
        return true;
    }

    /**
     * 用户删除
     * @param userId
     * @return
     */
    @Override
    public int deleteUser(int userId) {

        return userMapper.deleteUser(userId);
    }

    /**
     * 用户详情
     * @param userId
     * @return
     */
    @Override
    public User detailsUser(int userId) {

        return userMapper.detailsUser(userId);
    }


    @Override
    public User usersLogin(String account) {
        return userMapper.usersLogin(account);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
