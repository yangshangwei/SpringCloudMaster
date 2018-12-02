package com.artisan.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artisan.microservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
