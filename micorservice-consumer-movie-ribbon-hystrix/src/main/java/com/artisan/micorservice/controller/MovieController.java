package com.artisan.micorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.artisan.micorservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;


@RestController
public class MovieController {
 
  @Autowired
  private RestTemplate restTemplate;

  
  @Autowired
  LoadBalancerClient loadBalancerClient;
  
  @HystrixCommand(fallbackMethod = "findByIdDefault",commandProperties= {
		  @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
		  @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value="10000")
  },threadPoolProperties= {
		  @HystrixProperty(name="coreSize",value="1"),
		  @HystrixProperty(name="maxQueueSize",value="10")
  })
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
  }
  
  /**
   * 
   * @param id
   * @return
   * @desc 当请求失败、超时、被拒绝，或当断路器打开时，执行的逻辑
   */
  public User findByIdDefault(Long id) {
	  User user = new User();
	  user.setId(id);
	  user.setUsername("默认用户");
	 return user;
  }
  
}
