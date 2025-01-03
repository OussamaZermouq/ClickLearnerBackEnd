package com.clicklearner.msusers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class MsUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUsersApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
