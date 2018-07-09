package com.springBoot.SpringBootRestApiExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springBoot.service")
public class SpringBootRestApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiExampleApplication.class, args);
	}
}
