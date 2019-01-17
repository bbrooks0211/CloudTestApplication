package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.models.ForumPost;
import com.app.models.User;
import com.app.services.interfaces.ForumBusinessServiceInterface;

@Controller
public class ForumController {
	
	@Autowired
	private HttpSession httpSession;
	
	private ForumBusinessServiceInterface service;

	@RequestMapping(path="/forum", method=RequestMethod.GET)
	public ModelAndView displayForum() 
	{
		ModelAndView mv = new ModelAndView("forum");
		User user = (User) httpSession.getAttribute("user");
		if(user == null)
		{
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		mv.addObject("user", user);
		mv.addObject("post", new ForumPost());
		mv.addObject("posts", service.getAllPosts());
		
		return mv;
	}
	
	@RequestMapping(path="/submitPost", method=RequestMethod.POST)
	public ModelAndView addPost(@Valid @ModelAttribute("forum")ForumPost post) 
	{
		ModelAndView mv = new ModelAndView("redirect:/forum");
		User user = (User) httpSession.getAttribute("user");
		if(user == null)
		{
			mv.setViewName("redirect:/login");
			return mv;
		}
		if(post.getContent().equals(null) || post.getContent() == null)
			return mv;
		
		post.setUsername(user.getUsername());
		post.setUserID(user.getId());
		
		service.addNewPost(post);
		
		return mv;
	}
	
	@Autowired
	private void setForumBusinessService(ForumBusinessServiceInterface service) {
		this.service = service;
	}
}
