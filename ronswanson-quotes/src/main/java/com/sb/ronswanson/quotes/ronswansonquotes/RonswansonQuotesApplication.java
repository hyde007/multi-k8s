package com.sb.ronswanson.quotes.ronswansonquotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RonswansonQuotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RonswansonQuotesApplication.class, args);
	}

}

