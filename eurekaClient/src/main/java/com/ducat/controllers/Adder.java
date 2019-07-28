package com.ducat.controllers;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adder")
public class Adder {

	@RequestMapping(value="/add/{num1}/{num2}",
			method= {RequestMethod.GET})
	public int add(
			@PathVariable ("num1") int x, 
			@PathVariable("num2") int y)
	{
		System.out.println("add endpoint of adder is invoked, return result...");
		return x+y;
	}
}
