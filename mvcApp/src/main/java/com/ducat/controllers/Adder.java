package com.ducat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adder")
public class Adder {

	// Method to present the home page.
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	// Method to process add request.
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView doSum( 
		@RequestParam("num1")	int x,
		@RequestParam("num2") int y) {
		
		// processing is done
		int z = x + y;
		ModelAndView mav = new ModelAndView();
		//Result is stored in the ModelAndView object
		mav.addObject("sum", z);
		// ViewName is stored in ModelAndView
		mav.setViewName("result");
		// ModelAndView object is returned.
		return mav;
	}
	
}
