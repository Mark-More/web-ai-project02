package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")//拦截所有请求
@Slf4j
public class AbcFilter implements Filter {
    //初始化方法，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        log.info("AbcFilter初始化....");
    }

    //拦截到请求之后执行，会执行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("AbcFilter拦截到了请求....放行前....");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("AbcFilter放行之后，执行....放行后....");
    }

    //销毁的方法，web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
//        Filter.super.destroy();
        log.info("AbcFilter销毁....");
    }
}
