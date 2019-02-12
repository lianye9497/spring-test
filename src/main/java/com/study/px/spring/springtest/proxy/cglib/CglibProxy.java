package com.study.px.spring.springtest.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.net.ssl.SNIServerName;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 21:15
 **/
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        return methodProxy.invoke(o, args);
        return methodProxy.invokeSuper(o, args);
    }
}