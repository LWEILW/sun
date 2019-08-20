package com.sunshine.controller;


import com.alibaba.fastjson.JSONObject;
import com.sunshine.dao.RoleMapperEx;
import com.sunshine.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private RoleMapperEx uRoleDao;

//    //首页
//    @RequestMapping(value="index")
//    public String index() {
//        return "index";
//    }
//
//    //登录
//    @RequestMapping(value="login")
//    public String login() {
//        return "login";
//    }
//
//    //权限测试用
//    @RequestMapping(value="add")
//    public String add() {
//        return "add";
//    }
//
//    //未授权跳转的页面
//    @RequestMapping(value="403")
//    public String noPermissions() {
//        return "403";
//    }
//
//    //更新权限
//    @RequestMapping(value="updatePermission")
//    @ResponseBody
//    public String updatePermission() {
//        shiroService.updatePermission();
//        return "true";
//    }
//
//    //踢出用户
//    @RequestMapping(value="kickouting")
//    @ResponseBody
//    public String kickouting() {
//
//        return "kickout";
//    }
//
//    //被踢出后跳转的页面
//    @RequestMapping(value="kickout")
//    public String kickout() {
//        return "kickout";
//    }

    //跳转到登录表单页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "need login";
    }

    //登录成功后，跳转的页面
    @RequestMapping("/success")
    public String index(Model model) {
        return "success";
    }

    //未登录，可以访问的页面
    @RequestMapping("/index")
    public String list(Model model) {
        return "index";
    }

    //登陆验证，这里方便url测试，正式上线需要使用POST方式提交
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    public Map<String, Object> index(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String username = obj.getString("username");
        String password = obj.getString("password");
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        if (username != null && password != null) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, "login");
            Subject currentUser = SecurityUtils.getSubject();
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
            try {
                currentUser.login(token);
                System.out.println("查看登录的token:" + token);
                //验证是否登录成功
                if (currentUser.isAuthenticated()) {
                    resultMap.put("status", 200);
                    resultMap.put("message", "登录成功");
                    logger.info("登录成功, 用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
                } else {
                    token.clear();
                    resultMap.put("status", 500);
                    resultMap.put("message", "登录认证失败,重新登陆");
                    logger.info("用户[" + username + "]登录认证失败,重新登陆");
                }
            } catch (UnknownAccountException uae) {
                logger.info("对用户[" + username + "]进行登录验证..验证失败-username wasn't in the system");
            } catch (IncorrectCredentialsException ice) {
                logger.info("对用户[" + username + "]进行登录验证..验证失败-password didn't match");
            } catch (LockedAccountException lae) {
                logger.info("对用户[" + username + "]进行登录验证..验证失败-account is locked in the system");
            } catch (AuthenticationException ae) {
                logger.error(ae.getMessage());
            }
        }
        return resultMap;
    }

//    /**
//     * ajax登录请求接口方式登陆
//     *
//     * @param username
//     * @param password
//     * @return
//     */
//    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> submitLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
//        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
//        try {
//
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//            SecurityUtils.getSubject().login(token);
//            resultMap.put("status", 200);
//            resultMap.put("message", "登录成功");
//            System.out.println("登录成功");
//
//        } catch (Exception e) {
//            resultMap.put("status", 500);
//            resultMap.put("message", e.getMessage());
//        }
//        return resultMap;
//    }


    //登出
    @RequestMapping(value = "/logout")
    public String logout() {
        return "logout";
    }

    //错误页面展示
    @GetMapping("/403")
    public String error() {
        return "error ok!";
    }

    //管理员功能
    @RequiresRoles("admin")
    @RequiresPermissions("管理员添加")
    @RequestMapping(value = "/admin/add")
    public String create() {
        return "add success!";
    }

    //用户功能
    @RequiresRoles("user")
    @RequiresPermissions("用户查询")
    @RequestMapping(value = "/user/select")
    public String detail() {
        return "select success";
    }
}
