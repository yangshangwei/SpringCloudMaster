package com.artisan.micorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class MicorserviceConsumerFeginApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicorserviceConsumerFeginApplication.class, args);
	}
}
