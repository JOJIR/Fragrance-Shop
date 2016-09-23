package com.powerperfume.dao;

import java.util.List;

import com.powerperfume.model.User;
import com.powerperfume.model.UserDetails;



public interface UserDAO {


	public List<User> list();

	public User get(int sortOrder);

	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User email);
	
	public boolean isValidUser(User user);
	
	public boolean validateRegistration(UserDetails userDetails);
	
	public void registerUser(UserDetails userDetails); 
}

