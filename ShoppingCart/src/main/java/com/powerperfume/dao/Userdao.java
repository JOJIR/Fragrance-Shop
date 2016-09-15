package com.powerperfume.dao;

import java.util.List;

import org.apache.catalina.User;

public interface Userdao {


	public List<User> list();

	public User get(String id);

	public void saveOrUpdate(User user);
	
	public void saveOrUpdate(UserDetails userDetails);

	public void delete(String id);
	
	public boolean isValidUser(String id, String name, boolean isAdmin);



	

}
