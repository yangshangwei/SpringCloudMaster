package com.artisan.micorservice.feignclient;

import org.springframework.stereotype.Component;

import com.artisan.micorservice.model.User;

@Component
public class FeignClientCallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(id);
		user.setUsername("默认用户");
		return user;
	}

}
