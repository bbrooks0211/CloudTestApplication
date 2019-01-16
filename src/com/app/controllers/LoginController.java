package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.User;

@Controller
public class LoginController {
	
	@RequestMapping(path="/test", method=RequestMethod.GET)
	public ModelAndView testFunction() 
	{
		return new ModelAndView("helloWorld").addObject(new User());
	}
}
