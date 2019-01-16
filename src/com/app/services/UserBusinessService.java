package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.DataAccessInterface;
import com.app.models.User;
import com.app.services.interfaces.UserBusinessServiceInterface;

public class UserBusinessService implements UserBusinessServiceInterface {
	
	private DataAccessInterface<User> dao;

	@Override
	public boolean registerUser(User user) {
		return dao.create(user);
	}

	@Override
	public User loginUser(User user) {
		return dao.find(user);
	}

	@Override
	public User findUserByID(int id) {
		return dao.find(id);
	}
	
	@Autowired
	private void setUserDAO(DataAccessInterface<User> dao) {
		this.dao = dao;
	}

}
