package com.study.px.spring.springtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Configuration
public class BaseInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("BaseInterceptor preHandle");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        IgnoreToken methodAnnotation = handlerMethod.getMethodAnnotation(IgnoreToken.class);
        if(methodAnnotation != null){
            return true;
        }
        String token = request.getParameter("token");
        if(token == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("未授权");
            writer.close();
            return false;
        }
        Method method = handlerMethod.getMethod();
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("BaseInterceptor postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("BaseInterceptor afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
