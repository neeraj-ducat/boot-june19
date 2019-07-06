package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth4")
public class HomeController {

	
	
	@RequestMapping("/")
	public String index()
	{
		
		return "index";
	}
	@RequestMapping("/login")
	public String home()
	{
		
		return "login";
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
