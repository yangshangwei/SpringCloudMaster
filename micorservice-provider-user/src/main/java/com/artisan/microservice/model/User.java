package com.artisan.microservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 226695758444267342L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	
	@Column
	private String username;
	
	@Column
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private BigDecimal balance;
	
	
}
