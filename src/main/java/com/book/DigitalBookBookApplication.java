package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DigitalBookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBookBookApplication.class, args);
	}
}
