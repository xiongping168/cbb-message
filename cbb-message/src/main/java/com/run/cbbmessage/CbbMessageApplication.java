package com.run.cbbmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
//这个注解也是对于动态刷新
public class CbbMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbbMessageApplication.class, args);
    }

}
