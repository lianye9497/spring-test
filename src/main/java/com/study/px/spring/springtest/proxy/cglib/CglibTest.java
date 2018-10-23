package com.study.px.spring.springtest.proxy.cglib;

import com.study.px.spring.springtest.proxy.ProxyTestServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 21:18
 **/
public class CglibTest {

    public static void main(String[] args) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\work\\study\\spring-test\\");  //该设置用于输出cglib动态代理产生的类
        CglibProxy cglibProxy = new CglibProxy();

        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer enhancer = new Enhancer();
        //设置目标类
        enhancer.setSuperclass(ProxyTestServiceImpl.class);
        // 设置拦截对象
        enhancer.setCallback(cglibProxy);
        // 生成代理类并返回一个实例
        ProxyTestServiceImpl proxyTestService = (ProxyTestServiceImpl) enhancer.create();
        String cglib = proxyTestService.test("cglib");
        System.out.println(cglib);
    }
}
