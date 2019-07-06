package com.ducat.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth1")
public class HomeController {

	
	private void whoIs(String endPoint) { 
		
	 Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	 System.out.println("Endpoint"+endPoint+" is being accessed by "+auth.getName()+" user.");
	}
	
	@RequestMapping("/")
	public String home()
	{
		whoIs("/");
		return "index";
	}
	
	@RequestMapping(value="/about")
	public String about() throws Exception
	{
		whoIs("/about");
		return "about";
	}
	@RequestMapping(value="/contact")
	public String contact() throws Exception
	{
		whoIs("/contact");
		return "contact";
	}
	
}
