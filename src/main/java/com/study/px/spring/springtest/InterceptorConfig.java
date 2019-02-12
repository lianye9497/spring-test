package com.study.px.spring.springtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 添加拦截
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态访问资源
     * addResourceHandler对外暴露路径
     * addResourceLocations资源路径
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("classpath:/**.ico");
        super.addResourceHandlers(registry);
    }
}
