package com.powerperfume.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.CardDetails;
import com.powerperfume.model.User;

@Component
public class RegistrationHandler
{
	@Autowired
	UserDAO userDAO;
	
	public User getInstance()
	{
		User user = new User();
		user.getCardDetails().add(new CardDetails());
		return user;
	}

	public String validateDetails(User user, MessageContext messageContext)
	{
		String status = "success";

		if(user.getEmail().isEmpty())
		{
			messageContext
					.addMessage(new MessageBuilder().error().source("email").defaultText("Email cannot be empty").build());
			status = "failure";
		}
		if(user.getFirstName().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("firstName").defaultText("First Name cannot be empty").build());
			status = "failure";
		}
		if(user.getLastName().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("lastName").defaultText("Last Name cannot be empty").build());
			status = "failure";
		}
		if(user.getPassword().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("Password cannot be empty").build());
			status = "failure";
		}
		if(user.getContactNo().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("contactNo").defaultText("Mobile Number cannot be empty").build());
			status = "failure";
		}
		if(user.getShippingAddress().getStreet().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("shippingAddressStreet").defaultText("Shipping Address cannot be empty").build());
			status = "failure";
		}
		if(user.getShippingAddress().getStreet().isEmpty())
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("billingAddressStreet").defaultText("Shipping Address cannot be empty").build());
			status = "failure";
		}
		if(!userDAO.validateRegistration(user))
		{
			messageContext.addMessage(
					new MessageBuilder().error().source("email").defaultText("An account already exists with the given email address").build());
			status = "failure";
		}

		return status;
	}

	public void addUser(RequestContext context, User user)
	{
		HttpSession session = ((HttpServletRequest) context.getExternalContext().getNativeRequest()).getSession();
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("email", user.getEmail());
		userDAO.registerUser(user);
	}
}