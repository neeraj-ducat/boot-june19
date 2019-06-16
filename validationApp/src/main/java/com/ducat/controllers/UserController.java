package com.ducat.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ducat.models.User;
import com.ducat.repositories.UserDao;
import com.ducat.validators.MailValidator;

@Controller
@RequestMapping("mvc")
public class UserController {

	//Dependency of the Controller
	@Autowired
	UserDao dao;
	
	@Autowired
	MailValidator validator;
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user",new User());
		return mav;
	}
	
	@RequestMapping(value="/signup",
			method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute User user,
			BindingResult br) {
		ModelAndView mav = new ModelAndView();
		// custom validation is perfomred.
		validator.validate(user, br);
		
		if(br.hasErrors())
		{
			mav.setViewName("index");
		}
		else
		{	
			// save the object in the database
			dao.save(user);
			mav.setViewName("registered");
		}
		mav.addObject("user",user);
		return mav;
	}
}
