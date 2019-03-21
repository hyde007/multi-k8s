package com.sb.ronswanson.quotes.ronswansonquotes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@GetMapping("/")
	public String fetchStudentById(){
		
		return "Hello from ronswanson-quotes";
		
	}

}
