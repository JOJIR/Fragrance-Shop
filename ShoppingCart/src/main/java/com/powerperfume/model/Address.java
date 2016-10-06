package com.powerperfume.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Address {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	@NotBlank(message = "Street cannot be blank")
	private String street;
	
	
	@NotBlank(message = "City cannot be blank")
	private String city;
	
	
	@Min(0)
	private int pin;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}
}
	
	