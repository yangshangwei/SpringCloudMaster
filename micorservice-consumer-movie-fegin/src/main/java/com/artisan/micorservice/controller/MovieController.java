package com.artisan.micorservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artisan.micorservice.feignclient.UserFeignClient;
import com.artisan.micorservice.model.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovieController {
	
 @Autowired
 private UserFeignClient userClient;
	
  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    return userClient.findById(id);
  }
  
  /**
   * 
   * @param user
   * @return  
   * 	调用会出错
   */
  @GetMapping("/movie/getA")
  public User findUser(User user) {
	  log.info("get进入服务消费者 MovieController.findUser");
	  return userClient.finUser(user);
  }
  
  @GetMapping("/movie/getB")
  public User findUser2(User user) {
	  log.info("get2进入服务消费者 MovieController.findUser2");
	  return userClient.finUser(user.getUsername(),user.getAge());
  }
  
  @GetMapping("/movie/getC")
  public User findUser3(User user) {
	  log.info("get2进入服务消费者 MovieController.findUser3");
	  Map<String, Object> map = new HashMap<String, Object>() {
		  {
			  put("username",user.getUsername());
			  put("age",user.getAge());
		  }
	  };
	  return userClient.finUser(map);
  }
  
}
