package com.powerperfume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {
	
	@Id
	private String id;
	private String name;
	private String description;
	

	@Column(name = "is_male")
	private boolean isMale;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isMale() {
		return isMale;
	}


	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
}
	
	
	
	
	