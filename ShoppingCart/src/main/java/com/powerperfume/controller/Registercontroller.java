package com.powerperfume.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.User;

@Controller
public class RegisterController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/Register")
	public String register(@ModelAttribute User user, ModelMap model)
	{
		
		return "user/Register";
	}

	
	
	@RequestMapping(value="/RegisterAttempt", method=RequestMethod.POST)
	public ModelAndView registerAttempt(@ModelAttribute("user") User user, ModelMap model )
	{
		ModelAndView modelview = null;
		if(userDAO.validateRegistration(user))
		{
			userDAO.registerUser(user);
			modelview = new ModelAndView("user/UserHome");
				session.setAttribute("email", user.getEmail());
		}
		
		else
		{
			modelview = new ModelAndView("user/Register");
				modelview.addObject("error", "Account already exists with given email");
		}
		
		return modelview;
	}
}