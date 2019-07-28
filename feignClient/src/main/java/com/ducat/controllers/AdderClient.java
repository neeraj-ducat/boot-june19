package com.ducat.controllers;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("adder")
public interface AdderClient {

	@RequestMapping(value="/adder/add/{num1}/{num2}",
			method=RequestMethod.GET)
	public int fetchSum(
		@PathVariable("num1")	int x, 
		@PathVariable("num2")   int y);
}
