package com.sunshine.shiro;

import com.sunshine.dao.PermissionMapperEx;
import com.sunshine.dao.RoleMapperEx;
import com.sunshine.dao.UserMapperEx;
import com.sunshine.entity.Permission;
import com.sunshine.entity.Role;
import com.sunshine.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    //一般这里都写的是servic，这里省略直接调用dao
    @Autowired
    private UserMapperEx userMapperEx;
    @Autowired
    private RoleMapperEx roleMapperEx;
    @Autowired
    private PermissionMapperEx permissionMapperEx;

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("##################执行Shiro登录认证方法:doGetAuthenticationInfo()##################");

        //查出是否有此用户
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User hasUser = userMapperEx.selectAllByName(username);
        logger.info("获取到token为:" + token.toString() + "username:" + username);

        if (hasUser == null) {
            throw new AccountException("帐号或密码不正确！");
        } else if (hasUser.getStatus() == 0) {
            /** 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code> */
            throw new DisabledAccountException("帐号已经禁止登录！");
        } else if (hasUser != null) {
            //更新登录时间 last login time
            hasUser.setCreate_time(new Date());
            // 更新用户方法
            //sysUserService.updateById(user);

            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<Role> rlist = roleMapperEx.findRoleByUid(hasUser.getId());//获取用户角色
            List<Permission> plist = permissionMapperEx.findPermissionByUid(hasUser.getId());//获取用户权限
            List<String> roleStrlist = new ArrayList<String>();////用户的角色集合
            List<String> perminsStrlist = new ArrayList<String>();//用户的权限集合
            for (Role role : rlist) {
                roleStrlist.add(role.getName());
            }
            for (Permission uPermission : plist) {
                perminsStrlist.add(uPermission.getName());
            }
            hasUser.setRoleStrlist(roleStrlist);
            hasUser.setPerminsStrlist(perminsStrlist);
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());
        }

        return null;
    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证方法doGetAuthenticationInfo()##################");

        User user = (User) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}
