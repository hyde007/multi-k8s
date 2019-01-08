package com.sb.hml.homeworklog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.sb.hml.homeworklog.proxy")
public class HomeworkLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkLogApplication.class, args);
	}

}

