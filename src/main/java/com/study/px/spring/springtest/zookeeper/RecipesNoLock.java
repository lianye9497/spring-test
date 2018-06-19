package com.study.px.spring.springtest.zookeeper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-19 15:32
 **/
public class RecipesNoLock {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss|SSS");
                String date = simpleDateFormat.format(new Date());
                System.out.println(date);
            }).start();
        }
        countDownLatch.countDown();

    }



     public static RecipesNoLock.T t(){
          return new RecipesNoLock.T();
     }

     public static class T{

        public static void test(){

        }
     }
}
