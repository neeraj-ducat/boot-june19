package com.techmentro.controllers;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Adder {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home()
	{
		SecurityContext context=SecurityContextHolder.getContext();
		String user=context.getAuthentication().getName();
		System.out.println(user+" is accessing this page.");
		return "index";
	}
	
	
	
	
	@RequestMapping(value="/add",
			method=RequestMethod.POST)
	public ModelAndView add(
		@RequestParam("num1")	int x, 
		@RequestParam("num2") int y)
	{
		int z=x+y;
		ModelAndView mav=new ModelAndView();
		mav.setViewName("result");
		mav.addObject("sum",z);
		return mav;
	}
}
