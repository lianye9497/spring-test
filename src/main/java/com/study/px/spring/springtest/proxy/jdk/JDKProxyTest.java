package com.study.px.spring.springtest.proxy.jdk;

import com.study.px.spring.springtest.proxy.ProxyTestService;
import com.study.px.spring.springtest.proxy.ProxyTestServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 20:24
 **/
public class JDKProxyTest {

    public static void main(String[] args) {
//        new JDKProxyTest();

//        ProxyTestService person = null;
//        try {
//            person = (ProxyTestService) new JDKProxy().getInstance(new ProxyTestServiceImpl());
//            String ss = person.test("ss");
//            System.out.println(ss);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        ProxyTestService proxyTestService = new ProxyTestServiceImpl();
        ProxyTestService proxyInstance = (ProxyTestService) Proxy.newProxyInstance(ProxyTestService.class.getClassLoader(),
                new Class[]{ProxyTestService.class}, new JDKProxy(proxyTestService));
        String str = proxyInstance.test("你好");
        System.out.println(str);

        System.out.println("原生对象：" + proxyTestService.getClass());
        System.out.println("代理对象：" + proxyInstance.getClass());
    }
}
