package com.study.px.spring.springtest.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @description:分布式锁
 * @author: suding
 * @create: 2018-06-19 16:16
 **/
public class RecipesNoLock {
    final static String url = "192.168.46.128:2181";

    static final String path = "/recipes_lock_path";
    static CuratorFramework client = CuratorFrameworkFactory
            .builder()
            .connectString(url)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();

    public static void main(String[] args) {
        client.start();
        InterProcessMutex interProcessMutex = new InterProcessMutex(client, path);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                    interProcessMutex.acquire();//AQS cas
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS");
                String date = simpleDateFormat.format(new Date());
                System.out.println(date);
                try {
                    interProcessMutex.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
