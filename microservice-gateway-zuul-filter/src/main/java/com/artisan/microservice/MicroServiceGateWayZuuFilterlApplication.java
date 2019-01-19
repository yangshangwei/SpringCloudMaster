package com.artisan.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.artisan.microservice.zuulFilter.PreRequestZuulFilter;

@SpringBootApplication
@EnableZuulProxy
public class MicroServiceGateWayZuuFilterlApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(MicroServiceGateWayZuuFilterlApplication.class, args);
	}

	@Bean
	public PreRequestZuulFilter preRequestZuulFilter() {
		return new PreRequestZuulFilter();
	}
}
