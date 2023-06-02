package com.atbjut.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//127个底层自动配置类
//全部开启，但是最终按需加载
@SpringBootApplication
@MapperScan("com.atbjut.boot")
public class Springboot02Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02Application.class, args);
    }

}
/**
 * 1. 所有请求一进来就被DispatchServlet拦截->为当前请求找到一个 handlerMapping
 *
 * 2. 调用handlerMappings:{RequestMappingHandlerMapping, WelcomePageHandlerMapping,
 *                          BeanNameUrlHandlerMapping, RouterFunctionMapping, SimpleUrlHandlerMapping}
 *      1) RequestMappingHandlerMapping: 保存了所有 @RequestMapping 注解和 handler 映射
 *      2) WelcomePageHandlerMapping: 欢迎页 HandlerMapping
 * 3. 调用 handlerAdapters:{}
 *
 *
 *
 *
 *
 *
 * */