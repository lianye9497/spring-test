package com.study.px.spring.springtest.proxy;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 20:27
 **/
public class ProxyTestServiceImpl implements ProxyTestService {

    public String test(String msg){
        return "proxy," + msg;
    }
}
