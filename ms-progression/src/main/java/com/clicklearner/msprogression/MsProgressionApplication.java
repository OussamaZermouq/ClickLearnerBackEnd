package com.clicklearner.msprogression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsProgressionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProgressionApplication.class, args);
    }

}
