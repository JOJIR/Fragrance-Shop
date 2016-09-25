package com.powerperfume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class User{
	
	@Id
	public String email;
	public String password;
	
	@Column(name = "is_admin")
	private boolean isAdmin;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public boolean isAdmin()
	{
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getContactNo()
	{
		return contactNo;
	}
	public void setContactNo(String contactNo)
	{
		this.contactNo = contactNo;
	}

}