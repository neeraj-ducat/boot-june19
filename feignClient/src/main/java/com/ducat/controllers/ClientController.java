package com.ducat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ClientController {

	@Autowired
	AdderClient client;
	
	@HystrixCommand(fallbackMethod = "defaultResponse")
	@RequestMapping(value="/sum/{num1}/{num2}",method=RequestMethod.GET)
	public int getSum(
			@PathVariable("num1")	int x, 
			@PathVariable("num2")   int y)
	{
		System.out.println("Request is received by the front, invoking adder...");
		return client.fetchSum(x,y);
	}
	
	
	public int defaultResponse(int x, int y)
	{
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		return x+y;
	}
}
