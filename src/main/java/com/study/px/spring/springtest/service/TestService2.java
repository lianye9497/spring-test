package com.study.px.spring.springtest.service;

import com.study.px.spring.springtest.orm.mapper.ChannelMapper;
import com.study.px.spring.springtest.orm.model.Channel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: suding
 * @create: 2018-07-26 16:18
 **/
@Service
public class TestService2 {

    @Resource
    private ChannelMapper channelMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void callbackTest() {
//        SqlSession session = SqlSessionFactory.getSqlSession();
        Channel channel = channelMapper.selectByPrimaryKey(1);
        System.out.println("callbackTest="+channel.getUserNum());
        Integer userNum = channel.getUserNum();
        channel.setUserNum(userNum+1);
        channel.setName("uiuiuiuiu");
        channelMapper.updateByPrimaryKey(channel);
        String ss = null;
//        ss.equals(1);
    }
}
