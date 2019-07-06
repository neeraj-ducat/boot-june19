package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth3")
public class HomeController {

	
	
	@RequestMapping("/")
	public String home()
	{
		
		return "index";
	}
	
	@RequestMapping(value="/about")
	public String about() throws Exception
	{
		
		return "about";
	}
	@RequestMapping(value="/contact")
	public String contact() throws Exception
	{
		
		return "contact";
	}
	
}
