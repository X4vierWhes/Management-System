package com.example.ManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ManagementSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(ManagementSystemApplication.class, args);
	}
}