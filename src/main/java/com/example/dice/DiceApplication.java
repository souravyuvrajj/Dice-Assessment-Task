package com.example.dice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiceApplication.class, args);
	}

	@Bean
	public RestTemplate restRedisTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
