package com.study.px.spring.springtest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handlerMyException(MyException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("error type", "MyException");
        return result;
    }

}
