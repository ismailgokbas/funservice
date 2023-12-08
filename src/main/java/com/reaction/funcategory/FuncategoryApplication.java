package com.reaction.funcategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FuncategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncategoryApplication.class, args);
	}

}
