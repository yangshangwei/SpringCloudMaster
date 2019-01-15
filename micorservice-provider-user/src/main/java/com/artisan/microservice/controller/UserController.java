package com.artisan.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.artisan.microservice.model.User;
import com.artisan.microservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
	  log.info("匹配到了 Controller层的/user/{id}");
	  log.info("provider的UserController中的findById方法 ");
	  User user = new User();
      user.setId(id);
      
      User user2 = new User();
      user2.setName("no this user");
      // 我们使用的spring boot2.1.1版本中关联使用的spring data jpa不再支持findone(id)方法,改成如下写法
      return userRepository.findOne(Example.of(user)).orElse(user2); 
  }
  
  @GetMapping("/get")
  public User findUser(User user) {
	  log.info("匹配到了 Controller层的 /get");
	  log.info("姓名：{} , 年龄 {}" ,user.getUsername() , user.getAge());
	  return user;
  }
  
  @GetMapping("/api/{id}")
  public User findById2(@PathVariable Long id) {
	  log.info("匹配到了 Controller层的/api/{id}");
	  log.info("provider的UserController中的findById2方法 ");
	  User user = new User();
      user.setId(id);
      
      User user2 = new User();
      user2.setName("no this user");
      // 我们使用的spring boot2.1.1版本中关联使用的spring data jpa不再支持findone(id)方法,改成如下写法
      return userRepository.findOne(Example.of(user)).orElse(user2); 
  }
  
}
