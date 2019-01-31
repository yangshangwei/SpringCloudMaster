package com.artisan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtisanController {
	
	@Value("${name}")
	private String name;
	
	@Value("${profile}")
	private String profile;
	
	@GetMapping("/getVauleFromConfigServer")
	public String getValue() {
		return "config server中的内容：name=" + name + ",profile=" + profile;
	}

}
