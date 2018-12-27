package com.artisan.micorservice.feignclient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.artisan.micorservice.model.User;


@FeignClient("microservice-provider-user")
public interface UserFeignClient {

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User findById(@PathVariable Long id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public User finUser(User user);
		
	/**
	 * 
	 * @param username
	 * @param age
	 * @return
	 * @desc get的url中有几个参数,Feign接口的方法中就定义几个参数，使用@RequestParam注解指定请求的参数是什么
	 * 		 必须要加上@RequestParam注解，否则启动报错。
	 * 		
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public User finUser(@RequestParam("username") String username ,@RequestParam("age") Integer age);
	
	/**
	 * 
	 * @param map
	 * @return
	 * @desc 使用map来接收get请求的多个参数,@RequestParam不可少
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/get")
	public User finUser(@RequestParam Map<String, Object> map);

}
