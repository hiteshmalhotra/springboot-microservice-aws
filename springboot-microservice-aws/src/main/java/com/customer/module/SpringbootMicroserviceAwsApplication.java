package com.customer.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.customer.module")
public class SpringbootMicroserviceAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroserviceAwsApplication.class, args);
	}

}
