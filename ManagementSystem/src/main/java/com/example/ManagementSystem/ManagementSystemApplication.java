package com.example.ManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class }*/)
@EnableJpaRepositories(basePackages = "com.example.ManagementSystem.domain.user")
@EntityScan(basePackages = "com.example.ManagementSystem.domain.user")
public class ManagementSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(ManagementSystemApplication.class, args);
	}
}