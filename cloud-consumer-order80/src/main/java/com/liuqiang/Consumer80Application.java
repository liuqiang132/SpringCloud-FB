package com.liuqiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80Application.class,args);
    }
}
