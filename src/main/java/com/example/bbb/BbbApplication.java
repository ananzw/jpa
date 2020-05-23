package com.example.bbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbbApplication.class, args);
	}

}
