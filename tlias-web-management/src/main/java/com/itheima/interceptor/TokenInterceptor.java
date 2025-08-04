package com.itheima.interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        //1、获取到请求路径
//        String requestURI = request.getRequestURI();// /employees/login
//
//        //2、判断是否是登录请求，如果路径中包含/login，则放行，
//        if(requestURI.contains("/login")){
//            log.info("登录请求，放行");
//            return true;
//        }

        //3、获取请求头token
        String token = request.getHeader("token");

        //4、判断token是否为空，如果为空，说明用户没有登录，则返回错误信息(响应401状态码)
        if(token == null || token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //5、如果token存在，校验令牌，如果校验失败->返回错误信息(响应401状态码)
        try {
            JwtUtils.parseToken(token);
        }catch (Exception e){
            log.info("令牌校验失败，响应401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //6、如果校验成功，则放行
        log.info("令牌校验通过，放行");
        return true;
    }
}
