package com.artisan.microservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 8912111288470833198L;
	private Long id;
	private String username;
	private String name;
	private Integer age;
	private BigDecimal balance;

}
