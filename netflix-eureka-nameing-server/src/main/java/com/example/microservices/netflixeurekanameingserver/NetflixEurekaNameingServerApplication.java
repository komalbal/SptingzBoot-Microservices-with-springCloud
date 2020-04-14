package com.example.microservices.netflixeurekanameingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixEurekaNameingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNameingServerApplication.class, args);
	}

}
