package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.DataAccessInterface;
import com.app.models.ForumPost;
import com.app.services.interfaces.ForumBusinessServiceInterface;
import com.app.services.interfaces.UserBusinessServiceInterface;

public class ForumBusinessService implements ForumBusinessServiceInterface {
	
	DataAccessInterface<ForumPost> dao;
	UserBusinessServiceInterface userService;

	@Override
	public boolean addNewPost(ForumPost post) {
		return dao.create(post);
	}

	@Override
	public List<ForumPost> getAllPosts() {
		List<ForumPost> list = dao.findAll();
		for(ForumPost post : list)
		{
			post.setUsername(userService.findUserByID(post.getUserID()).getUsername());
		}
		return list;
	}

	@Autowired
	private void setForumDAO(DataAccessInterface<ForumPost> dao) {
		this.dao = dao;
	}
	
	@Autowired
	private void setUserBusinessService(UserBusinessServiceInterface service) 
	{
		this.userService = service;
	}
}
