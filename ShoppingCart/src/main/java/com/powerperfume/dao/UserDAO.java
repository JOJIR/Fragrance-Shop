package com.powerperfume.dao;

import java.util.List;

import com.powerperfume.model.User;
import com.powerperfume.model.UserDetails;



public interface UserDAO {


	public List<User> list();

	public User get(Integer id);

	public void saveOrUpdate(User user);
	
	public void saveOrUpdate(UserDetails userDetails);

	public void delete(Integer id);
	
	public boolean isValidUser(String email, String password, boolean isAdmin);
	
	public boolean validateRegistration(UserDetails userDetails);


}

