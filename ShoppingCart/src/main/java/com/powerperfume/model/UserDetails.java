package com.powerperfume.model;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {
	private User user;
	private Address shippingAddress;
	private Address billingAddress;
	private CardDetails cardDetails;
	
	public UserDetails()
	{
		user = new User();
		shippingAddress = new Address();
		shippingAddress.setShipping(true);
		billingAddress = new Address();
		cardDetails = new CardDetails();
	}
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public CardDetails getCardDetails()
	{
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails)
	{
		this.cardDetails = cardDetails;
	}


	public Address getShippingAddress()
	{
		return shippingAddress;
	}


	public void setShippingAddress(Address shippingAddress)
	{
		this.shippingAddress = shippingAddress;
	}


	public Address getBillingAddress()
	{
		return billingAddress;
	}


	public void setBillingAddress(Address billingAddress)
	{
		this.billingAddress = billingAddress;
	}
}


	
	

	
	