package com.study.px.spring.springtest.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.px.spring.springtest.IgnoreToken;
import com.study.px.spring.springtest.MyException;
import com.study.px.spring.springtest.orm.mapper.ChannelMapper;
import com.study.px.spring.springtest.orm.model.Channel;
import com.study.px.spring.springtest.orm.model.ChannelExample;
import com.study.px.spring.springtest.service.TestService;
import com.study.px.spring.springtest.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController{

    @Resource
    private TestService testService;

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list.toString());
    }

    @IgnoreToken
    @GetMapping("test1")
    public String test1(){
        testService.test1(1000);
        System.out.println("test1");
        String s = "123";
        return s;
    }

    @IgnoreToken
    @GetMapping("test4")
    public void test4(){
        testService.test4();
        System.out.println("test4");
        String s = "123";
    }

    @IgnoreToken
    @GetMapping("test2")
    public String test2() throws Exception{
        List<Channel> channels = testService.test1(5000);
        System.out.println("test2");
        PageInfo<Channel> channelPageInfo = new PageInfo<>(channels);
        String s1 = JSONObject.toJSONString(channelPageInfo);
        throw new MyException("101", "Sam 错误");
      //  return s1;
    }

    @IgnoreToken
    @PostMapping("test3")
    public String test3(@RequestBody @Validated PageVO pageVO, BindingResult bindingResult){
        String result = null;

        if (bindingResult.getErrorCount() == 0) {
            result = "通过验证！";
        }

        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError error : allErrors) {
            String defaultMessage = error.getDefaultMessage();
            System.out.println(defaultMessage);
        }
        return "333";
    }

}
