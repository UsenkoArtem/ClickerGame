package com.clicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.clicker.repository")
public class ClickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickerApplication.class, args);
	}
}
