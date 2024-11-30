package com.example.RedisSpring_pet3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisSpringPet3Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisSpringPet3Application.class, args);
	}

}
