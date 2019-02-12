package com.study.px.spring.springtest.controller;

import com.study.px.spring.springtest.BaseResult;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 14:15
 **/
public class BaseController {

    public BaseResult success(){
        return new BaseResult();
    }

    public <T> BaseResult<T> successWithData(T data){
        return new BaseResult<>(data);
    }

    public BaseResult fail(){
        return new BaseResult();
    }

    public BaseResult failWithMsg(String msg){
        return new BaseResult<>(msg);
    }
}
