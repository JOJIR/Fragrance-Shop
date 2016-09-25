package com.powerperfume.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import com.powerperfume.dao.AddressDAO;
import com.powerperfume.dao.CardDetailsDAO;
import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.Address;
import com.powerperfume.model.User;
import com.powerperfume.model.UserDetails;

@Controller
public class Registercontroller {
	@Autowired
	UserDAO userDAO;
	
	
	
	
	
	
	@RequestMapping ("/Register")
	public String register(@ModelAttribute("userDetails")UserDetails userDetails)
	{
	
		return "Register";
	}
	
	@RequestMapping(value="/RegisterAttempt", method=RequestMethod.POST)
	public ModelAndView registerAttempt(@ModelAttribute("userDetails") UserDetails userDetails, ModelMap Model )
	{
		ModelAndView modelview = null;
		if(userDAO.validateRegistration(userDetails))
		{
			userDAO.registerUser(userDetails);
			modelview = new ModelAndView("UserHome");
				modelview.addObject("email", userDetails.getUser().getEmail());
		}
		
		else
		{
			modelview = new ModelAndView("Register");
				modelview.addObject("error", "Account already exists with given email");
		}
		
		return modelview;
	}
}