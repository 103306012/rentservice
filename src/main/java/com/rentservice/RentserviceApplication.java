package com.rentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@EnableCaching
public class RentserviceApplication {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RentserviceApplication.class, args);

	}

}
