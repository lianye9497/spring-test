package com.study.px.spring.springtest.rpc.rmi;

import com.px.study.moremodule.client.rpc.rmi.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @description:
 * @author: 苏定
 * @create: 2018-10-22 12:04
 **/
public class ClientDemo {
    public static void main(String[] args) {
        try {
            Remote lookup = Naming.lookup("rmi://192.168.46.1:1099/test");
            HelloService helloService = (HelloService) Naming.lookup("rmi://192.168.46.1:1099/test");
            System.out.println(1);
            Thread.sleep(2000);
            String hhh = helloService.sayHello("hhh");
            System.out.println(hhh);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
