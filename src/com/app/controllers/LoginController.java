package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.User;
import com.app.services.interfaces.UserBusinessServiceInterface;

@Controller
public class LoginController {
	
	UserBusinessServiceInterface userService;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(path="/test", method=RequestMethod.GET)
	public ModelAndView testFunction() 
	{
		return new ModelAndView("helloWorld").addObject(new User());
	}
	
	@RequestMapping(path={"/", "/login"}, method=RequestMethod.GET)
	public ModelAndView displayLoginPage() 
	{
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView displayRegisterPage() 
	{
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		return mv;
	}
	
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user")User user) 
	{
		ModelAndView mv = new ModelAndView("redirect:/login");
		boolean result = userService.registerUser(user);
		
		if(!result)
			mv.setViewName("redirect:/register");
		
		return mv;
	}
	
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user")User user) 
	{
		ModelAndView mv = new ModelAndView("redirect:/forum");
		user = userService.loginUser(user);
		
		if(user.getId() == -1)
		{
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		httpSession.setAttribute("user", user);
		
		return mv;
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public ModelAndView logout() 
	{
		ModelAndView mv = new ModelAndView("redirect:/login");
		mv.addObject("user", new User());
		httpSession.removeAttribute("user");
		return mv;
	}
	
	@Autowired
	private void setUserBusinessService(UserBusinessServiceInterface service) 
	{
		this.userService = service;
	}
}
