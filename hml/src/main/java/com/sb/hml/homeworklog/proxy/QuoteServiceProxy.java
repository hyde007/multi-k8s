package com.sb.hml.homeworklog.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="ronswanson-quotes",url="localhost:9000")
@FeignClient(name="ronswanson-quotes")
@RibbonClient(name="ronswanson-quotes")
public interface QuoteServiceProxy {
	
	@GetMapping("/quotes/")
	public Quote getQuote();

}
