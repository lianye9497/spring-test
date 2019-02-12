package com.study.px.spring.springtest;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-01-31 14:14
 **/
public class BaseResult<T> {

    private T data;

    private Integer code = 1;

    private String msg;

    public BaseResult() {
        this.code = 1;
        this.msg = "操作成功!";
    }

    public BaseResult(T data) {
        this.code = 1;
        this.msg = "操作成功!";
        this.data = data;
    }

    public BaseResult(String msg) {
        this.code = 0;
        this.msg = msg;
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
