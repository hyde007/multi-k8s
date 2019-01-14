package com.sb.zuulgateway.zuulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sb.zuulgateway.zuulapi.filter.GatewayFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiApplication.class, args);
	}

	@Bean
	public GatewayFilter gatewayFilter() {
		return new GatewayFilter();
	}
	
	
}

