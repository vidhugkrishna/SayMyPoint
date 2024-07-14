package com.vidhu.sayMyPoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SayMyPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayMyPointApplication.class, args);
	}

}
