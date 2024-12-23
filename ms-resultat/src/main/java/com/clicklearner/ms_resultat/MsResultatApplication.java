package com.clicklearner.ms_resultat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsResultatApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsResultatApplication.class, args);
	}

}
