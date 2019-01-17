package com.app.services.interfaces;

import java.util.List;

import com.app.models.ForumPost;

public interface ForumBusinessServiceInterface {
	public boolean addNewPost(ForumPost post);
	public List<ForumPost> getAllPosts();
}
