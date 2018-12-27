package com.artisan.micorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class MicorserviceConsumerFeginHystrixApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicorserviceConsumerFeginHystrixApplication.class, args);
	}
}
