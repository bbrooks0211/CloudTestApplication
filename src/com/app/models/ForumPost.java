package com.app.models;

public class ForumPost {
	private int id;
	private int userID;
	private String username;
	private String content;
	private String category = "default";
	
	public ForumPost() {
		super();
		this.id = -1;
		this.userID = -1;
		this.content = "";
		this.category = "default";
		this.username = "";
	}
	
	public ForumPost(int id, int userID, String content, String category, String username) {
		super();
		this.id = id;
		this.userID = userID;
		this.content = content;
		this.category = category;
		this.username = username;
	}
	
	public ForumPost(int id, int userID, String content) {
		super();
		this.id = id;
		this.userID = userID;
		this.content = content;
	}
	
	public ForumPost(int id, int userID, String content, String category) {
		super();
		this.id = id;
		this.userID = userID;
		this.content = content;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
