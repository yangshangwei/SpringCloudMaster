package com.artisan.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GateWayZuulFallBackApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(GateWayZuulFallBackApplication.class, args);
	}

}
