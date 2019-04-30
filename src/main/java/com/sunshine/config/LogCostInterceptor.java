package com.sunshine.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogCostInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();

    /**
     * preHandle是请求执行前执行的，
     * postHandler是请求结束执行的，但只有preHandle方法返回true的时候才会执行，
     * afterCompletion是视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作。
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // log.info("SessionInterceptor preHandle方法，在请求方法之前调用，Controller方法调用之前");
        ////  代码示例
        // HttpSession session = httpServletRequest.getSession();
        //// 用户已登录
        // if (session.getAttribute("user") != null) {
        //     return true;
        // } else {//用户未登录，直接跳转登录页面
        //     httpServletResponse.sendRedirect("/login");
        //    return false;
        // }

        start = System.currentTimeMillis();
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // log.info("SessionInterceptor postHandle方法，请求处理之后调用，但是在视图被渲染之前（Controller方法调用之后）");
        System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // log.info("SessionInterceptor afterCompletion方法，在整个请求结束之后调用，也就是在Dispatcher渲染了整个视图之后进行（主要进行资源清理工作）");

    }
}
