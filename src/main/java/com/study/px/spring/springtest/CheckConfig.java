package com.study.px.spring.springtest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class CheckConfig {

//    @Pointcut("execution(* com.study.px.spring.springtest.controller..*.*(..))")
    @Pointcut("@within(com.study.px.spring.springtest.TT) || @annotation(com.study.px.spring.springtest.TT)")
    public void controllerPoint(){}

    @Before("controllerPoint()")
    public Object Around(JoinPoint joinPoint){
        System.out.println("CheckConfig before");
        Object target = joinPoint.getTarget();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        TT annotation1 = targetMethod.getAnnotation(TT.class);
        new UrlBasedCorsConfigurationSource();
        Validated annotation = targetMethod.getAnnotation(Validated.class);
        if(annotation != null){

        }
        List<Object> objects = Arrays.asList(joinPoint.getArgs());
        BindingResult bindingResult = null;
        for (Object object : objects) {
            if(object instanceof BindingResult){
                bindingResult = (BindingResult)object;
            }
        }
//        if (bindingResult !=null) {
//            if( bindingResult.getErrorCount() > 0){
//                List<ObjectError> allErrors = bindingResult.getAllErrors();
//                for (ObjectError error : allErrors) {
//                    String defaultMessage = error.getDefaultMessage();
//                    System.out.println(defaultMessage);
//                }
//                return null;
//            }
//        }else {
//            try {
//                return joinPoint.proceed();
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        }

        String kind = joinPoint.getKind();
//        Signature signature = joinPoint.getSignature();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        Object aThis = joinPoint.getThis();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        Class<? extends JoinPoint> aClass = joinPoint.getClass();
        Class<?>[] argTypes = new Class[joinPoint.getArgs().length];
//        try {
//            Method method = joinPoint.getTarget().getClass()
//                    .getMethod(joinPoint.getSignature().getName(), argTypes);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        MethodSignature methodSignature = (MethodSignature)signature;
//        Method targetMethod = methodSignature.getMethod();
//        Validated annotation = targetMethod.getAnnotation(Validated.class);
//        if(annotation != null){
//
//        }
        return null;





    }
}
