package com.wuzengrui.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.io.IOException;

//@WebFilter("/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init初始方法执行了");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("放行前的逻辑");
//        String token = (String) servletRequest.getAttribute("token");

//        放行请求
        filterChain.doFilter(servletRequest, servletResponse);

//        System.out.println("放行后的逻辑");
    }

    @Override
    public void destroy() {
//        System.out.println("destroy销毁方法执行了");
        Filter.super.destroy();
    }
}
