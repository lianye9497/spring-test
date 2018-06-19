package com.study.px.spring.springtest.service;

import com.github.pagehelper.PageHelper;
import com.study.px.spring.springtest.TT;
import com.study.px.spring.springtest.orm.mapper.ChannelMapper;
import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.orm.model.ChannelExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: suding
 * @create: 2018-06-05 17:03
 **/
@Service
public class TestServiceImpl implements TestService{

    @Resource
    private ChannelMapper channelMapper;

    public synchronized List<Channel> test1(long time){
        PageHelper.startPage(1,1);
        List<Channel> channels = channelMapper.selectByExample(new ChannelExample());
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return channels;
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
        test1(2000);
    }

    @Override
    public List<Channel> test1(int i) {
        return null;
    }
}
