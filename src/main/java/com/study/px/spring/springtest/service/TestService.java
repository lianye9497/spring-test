package com.study.px.spring.springtest.service;

import com.github.pagehelper.PageHelper;
import com.study.px.spring.springtest.BusinessException;
import com.study.px.spring.springtest.MyException;
import com.study.px.spring.springtest.orm.mapper.ChannelMapper;
import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.orm.model.ChannelExample;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public interface TestService {

    void test4();

    List<Channel> test1(int i);
}
