package com.artisan.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHa3NodeApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(EurekaHa3NodeApplication.class, args);
	}

}
