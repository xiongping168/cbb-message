package com.run.cbbmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CbbMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbbMessageApplication.class, args);
    }

}
