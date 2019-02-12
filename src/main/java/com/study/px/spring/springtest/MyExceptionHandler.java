package com.study.px.spring.springtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResult handlerMyException(Exception ex) {
        BaseResult<Object> result = new BaseResult<>();
        if (ex instanceof MyException){
            Map<String,Object> map = new HashMap<>();
            map.put("message", ex.getMessage());
            map.put("error type", "MyException");
            result.setData(map);
        }else {
            log.error("系统异常", ex);
            Map<String,Object> map = new HashMap<>();
            map.put("message", "系统异常");
            map.put("error type", "sss");
            result.setData(map);
        }

        return result;
    }

}
