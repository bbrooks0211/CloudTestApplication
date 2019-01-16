package com.app.services.interfaces;

import com.app.models.User;

public interface UserBusinessServiceInterface {
	public boolean registerUser(User user);
	public User loginUser(User user);
	public User findUserByID(int id);
}
