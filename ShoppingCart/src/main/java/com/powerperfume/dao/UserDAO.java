package com.powerperfume.dao;

import java.util.List;

import com.powerperfume.model.User;




public interface UserDAO {


	public List<User> list(int sortOrder);

	public User get(String email);

	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(String email);
	
	public User getValidUser(User user);
	
	public boolean validateRegistration(User user);
	
	public void registerUser(User user); 
}

