package com.study.px.spring.springtest.proxy.jdk;

import com.study.px.spring.springtest.proxy.ProxyTestService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 20:21
 **/
public class JDKProxy implements InvocationHandler {

    private ProxyTestService object;

    public JDKProxy(ProxyTestService object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return method.invoke(proxy,args);//死循环
        return method.invoke(object, args);
    }
}