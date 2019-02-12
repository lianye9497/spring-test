package com.study.px.spring.springtest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter
public class BaseFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("BaseFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter----调用service之前执行一段代码----");
        filterChain.doFilter(servletRequest, servletResponse); // 执行目标资源，放行
        System.out.println("doFilter----调用service之后执行一段代码----");
    }

    @Override
    public void destroy() {
        System.out.println("BaseFilter destory");
    }
}
