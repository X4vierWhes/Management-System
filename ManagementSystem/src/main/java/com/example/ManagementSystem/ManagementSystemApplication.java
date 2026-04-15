package com.example.ManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.ManagementSystem.domain.user",
		"com.example.ManagementSystem.domain.unit",
		"com.example.ManagementSystem.domain.block",
		"com.example.ManagementSystem.domain.ticket",
})
@EntityScan(basePackages = {"com.example.ManagementSystem.domain.user",
		"com.example.ManagementSystem.domain.unit",
		"com.example.ManagementSystem.domain.block",
		"com.example.ManagementSystem.domain.ticket",
})
public class ManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementSystemApplication.class, args);
	}
}