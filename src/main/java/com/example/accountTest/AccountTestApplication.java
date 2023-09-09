package com.example.accountTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)


public class AccountTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountTestApplication.class, args);
	}

}