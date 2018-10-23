package com.study.px.spring.springtest.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 21:15
 **/
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        Object result = methodProxy.invoke(o, args);
        return methodProxy.invokeSuper(o, args);
    }
}
