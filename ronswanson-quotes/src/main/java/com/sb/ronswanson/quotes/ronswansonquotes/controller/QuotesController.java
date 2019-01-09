package com.sb.ronswanson.quotes.ronswansonquotes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/quotes")
public class QuotesController {
	
	private static final String RONSWANSON_URL = "http://ron-swanson-quotes.herokuapp.com/v2/quotes/";
	
	@GetMapping("/")
	public Quote getQuotes() {
		
		RestTemplate restTemplate = new RestTemplate();
		List<String> result = restTemplate.getForObject(RONSWANSON_URL, List.class);
		
		Quote quote = new Quote();
		quote.setQuote(result.get(0));
		
		return quote;
		
	}

}
