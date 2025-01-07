package com.clicklearner.ms_cours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCoursApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsCoursApplication.class, args);
    }
}
