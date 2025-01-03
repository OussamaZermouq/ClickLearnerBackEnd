package com.clicklearner.clicklearnergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClicklearnerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClicklearnerGatewayApplication.class, args);
	}

}
