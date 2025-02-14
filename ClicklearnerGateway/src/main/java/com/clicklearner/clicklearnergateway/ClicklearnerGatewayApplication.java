package com.clicklearner.clicklearnergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ClicklearnerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClicklearnerGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		System.out.println("HELLO");
		return builder.routes()
				.route(p -> p
						//cours
						.path("/ms-cours/api/v1/**")
						.uri("http://localhost:8088/ms-cours/api/v1/")
				)
				.route(p -> p
						//users
						.path("/ms-users/api/v1/**")
						.uri("http://localhost:8084/ms-users/api/v1/")
				)
				.route(p -> p
						//progression
						.path("/ms-progression/api/v1/**")
						.uri("http://localhost:8089/ms-progression/api/v1/")
				)
				.route(p -> p
						//progression
						.path("/ms-devoir/api/v1/**")
						.uri("http://localhost:8086/ms-devoir/api/v1/")
				)

				.route(p -> p
						//progression
						.path("/ms-resultat/api/v1/**")
						.uri("http://localhost:8087/ms-resultat/api/v1/")
				)
				.route(p -> p
						//progression
						.path("/ms-examen/api/v1/**")
						.uri("http://localhost:8085/ms-examen/api/v1/")
				)

				.build();
	}

}
