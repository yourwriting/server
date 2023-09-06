package com.realWriting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RealWritingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealWritingApplication.class, args);
	}

}
