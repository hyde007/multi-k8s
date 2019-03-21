package com.sb.hml.homeworklog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@GetMapping("/")
	public String fetchStudentById(){
		
		return "Hello from homework-log";
		
	}

}
