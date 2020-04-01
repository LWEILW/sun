package com.blogger.controller;

import com.alibaba.fastjson.JSONObject;
import com.blogger.server.admin.UserService;
import com.blogger.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录管理
 *
 * @author Liu wei
 * @date 2020-03-31 16:00
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;


    /**
     * 登录
     *
     * @return
     */
    @GetMapping(value = "/loginGet")
    public Result defaultLogin() {

        System.out.println("登录成功");
        return Result.fail("登录成功");
    }


    /**
     * 登录
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody String data) {
        JSONObject obj = JSONObject.parseObject(data);
        String userName = obj.getString("userName");
        String password = obj.getString("password");

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }


    /**
     * 登出
     *
     * @return
     */
    @GetMapping(value = "/loginOut")
    public Result loginOut() {

        System.out.println("无权限");
        return Result.fail("没有权限");
    }


    /**
     * 错误页面展示
     *
     * @return
     */
    @GetMapping("/403")
    public String error() {
        return "error ok!";
    }


    /**
     * 身份认证测试接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {

        Object user = request.getSession().getAttribute("user");
        return "success";
    }


    /**
     * 角色认证测试接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/student")
    public String student(HttpServletRequest request) {

        return "success";
    }


    /**
     * 权限认证测试接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request) {

        return "success";
    }

}
