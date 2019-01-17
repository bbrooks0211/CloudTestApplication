package com.app.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.ForumPost;
import com.app.models.RestResponse;
import com.app.services.interfaces.ForumBusinessServiceInterface;

@Path("/forum")
@Service
public class ForumRestService {
	
	private static ForumBusinessServiceInterface service;
	
	@GET
	@Path("getAllPosts")
	@Produces("application/json")
	public RestResponse<List<ForumPost>> showAllPosts() {
		RestResponse<List<ForumPost>> response;
		response = new RestResponse<List<ForumPost>>(1, "OK", service.getAllPosts());
		
		return response;
	}
	
	@Autowired
	private void setForumBusinessService(ForumBusinessServiceInterface service) {
		this.service = service;
	}
}
