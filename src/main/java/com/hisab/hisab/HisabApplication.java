package com.hisab.hisab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HisabApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisabApplication.class, args);
	}

}
