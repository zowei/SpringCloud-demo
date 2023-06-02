package com.atbjut.boot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //告诉 Spring 容器，这是一个Spring配置类
@EnableSwagger2  //开启 Swagger2 功能
public class SwaggerConfig {

    @Bean
    public Docket createRestAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                //com包下面的所有接口都交给Swagger2管理
                .apis(RequestHandlerSelectors.basePackage("com"))
                .paths(PathSelectors.any()).build();

    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("演示项目API")
                .description("演示项目")
                .version("1.0")
                .build();
    }
}
