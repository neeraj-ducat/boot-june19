package com.ducat.controllers;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/adder")
public class Subtractor {

	@RequestMapping(value="/diff/{num1}/{num2}",
			method= {RequestMethod.GET})
	public int subtract(
			@PathVariable ("num1") int x, 
			@PathVariable("num2") int y)
	{
		System.out.println("subtract() of SubtractorService is invoked with input "+x+" & "+y);
		return x-y;
	}
}
