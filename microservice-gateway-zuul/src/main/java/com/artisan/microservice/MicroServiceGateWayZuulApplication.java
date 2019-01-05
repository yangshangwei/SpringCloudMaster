package com.artisan.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroServiceGateWayZuulApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(MicroServiceGateWayZuulApplication.class, args);
	}

}
