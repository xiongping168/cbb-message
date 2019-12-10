package com.run.cbbmessage.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * TODO
 *
 * @Author fanenjie
 * @Date 2019/10/23
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //控制不暴露出去的接口，可用@ApiIgnore注解
//                .apis(RequestHandlerSelectors.basePackage("com.example.zwd.springbootswagger2.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("CBB RESTful APIs - 消息中心")
                .termsOfServiceUrl("")
                .contact(new Contact("通用应用部","",""))
                .version("V1.0")
                .description("")
                .build();
    }
}



















