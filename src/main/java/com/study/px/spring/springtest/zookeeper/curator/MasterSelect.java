package com.study.px.spring.springtest.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import com.study.px.spring.springtest.zookeeper.RecipesNoLock ;

/**
 * @description: master选举
 * @author: suding
 * @create: 2018-06-13 16:50
 **/
public class MasterSelect {

    //java ...
    //zkClient ...
    //curator...

    static String path = "/master_path";

    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("192.168.46.128:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
    public static void main(String[] args) {
        client.start();
        try {
//            client.create().withMode(CreateMode.EPHEMERAL).forPath(path,"1ee".getBytes());
//            byte[] bytes = client.getData().forPath(path);
//            System.out.println(new String(bytes));
            LeaderSelector leaderSelector = new LeaderSelector(client, path, new LeaderSelectorListenerAdapter() {
                @Override
                public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                    System.out.println("成为master");
                    Thread.sleep(30000);
                    System.out.println("完成mater操作");
                }
            });
            leaderSelector.autoRequeue();
            leaderSelector.start();
            Thread.sleep(Integer.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
