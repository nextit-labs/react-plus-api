package com.nextit.reactplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
