package com.artisan.micorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.artisan.micorservice.model.User;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class MovieController {
 
  @Autowired
  private RestTemplate restTemplate;

  
  @Autowired
  LoadBalancerClient loadBalancerClient;
  
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
	 // 调用注册在Eureka上的服务端的地址
    return this.restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
  }
  
  @GetMapping("/callProvider")
  public String callProvider() {
	  ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
	  // 打印当前选择的哪个节点
	  log.info("serviceId: {} , host: {} ,port: {} ,uri: {}" ,serviceInstance.getServiceId() , serviceInstance.getHost(), serviceInstance.getPort(),serviceInstance.getUri());
	  return serviceInstance.getUri().toString();
  }
  
  
}
