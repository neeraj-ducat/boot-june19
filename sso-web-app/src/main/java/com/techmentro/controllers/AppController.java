package com.techmentro.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

		@RequestMapping("/")
		String home(Principal principal,HttpSession session) {
			System.out.println("logged In user is: "+principal.getName());
			session.setAttribute("user",principal.getName());
		    return "index";
		}
		//method to process add request
		@RequestMapping(value="/add", method=RequestMethod.POST)
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
