package com.study.px.spring.springtest.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.pagehelper.PageHelper;
import com.px.study.moremodule.client.CallbackService;
import com.px.study.moremodule.client.ChannelService;
import com.study.px.spring.springtest.TT;
import com.study.px.spring.springtest.orm.mapper.ChannelMapper;
import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.orm.model.ChannelExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-05 17:03
 **/
@Service
public class TestServiceImpl implements TestService{

    @Resource
    private ChannelMapper channelMapper;

    @Resource
    private TestService2 testService2;


    @Resource
    ChannelService channelService;

    @Resource
    CallbackService callbackService;


    @Transactional
     public synchronized List<Channel> test1(long time){

        List<Channel> channels2 = channelMapper.selectByExample(new ChannelExample());
        Channel channel1 = channelMapper.selectByPrimaryKey(1);
        testService2.callbackTest();
        channel1 = channelMapper.selectByPrimaryKey(1);
        Channel channel = channels2.get(0);
        channel.setName("1212");
        try {
            System.out.println("准备睡眠");
//            Thread.sleep(5000);
            channel.setName("sssss");
            channelMapper.updateByPrimaryKey(channel);
            testService2.callbackTest();
//            String ss = null;
//            ss.equals(1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            System.out.println("finally");
        }
        System.out.println(channels2.size());
//        channelMapper.updateByPrimaryKey(channel);

//        String s = channelService.test1();
//        Future<Object> future = RpcContext.getContext().getFuture();
//        try {
//            Object o = future.get();
//            System.out.println(o.toString());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        List<com.px.study.moremodule.dao.common.orm.model.Channel> channels1 = channelService.test2();
//        System.out.println(s);
//        List<com.px.study.moremodule.dao.common.orm.model.Channel> test = channelService.test();
//
//        PageHelper.startPage(1,1);
//        List<Channel> channels = channelMapper.selectByExample(new ChannelExample());
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return channels2;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void callbackTest() {
//        SqlSession session = SqlSessionFactory.getSqlSession();
        Channel channel = channelMapper.selectByPrimaryKey(1);
        System.out.println("callbackTest="+channel.getUserNum());
        Integer userNum = channel.getUserNum();
        channel.setUserNum(userNum+1);
        channelMapper.updateByPrimaryKey(channel);
    }

    @Transactional
    public void tet(){
        save();
        System.out.println(1);
        System.out.println(2);
    }

    @Transactional
    public void save(){
        Channel channel = new Channel();
        channel.setName("3121");
        channel.setId(1);
//        dd(channel);
        int i = channelMapper.insert(channel);
    }

    public void dd(Channel channel){
        int i = channelMapper.insert(channel);
    }

    @TT
    public void test4(){
        Channel channel = channelMapper.selectByPrimaryKey(1);
        System.out.println("test4="+channel.getUserNum());
        Integer userNum = channel.getUserNum();
        channel.setUserNum(userNum+1);
        channelMapper.updateByPrimaryKey(channel);
//        test1(2000);
    }

}
