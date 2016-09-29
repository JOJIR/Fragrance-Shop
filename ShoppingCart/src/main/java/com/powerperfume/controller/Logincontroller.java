package com.powerperfume.controller;

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
public class LoginController{

	@Autowired
	UserDAO userdao;
	
	@RequestMapping("/Login")
	public ModelAndView login(@ModelAttribute("user") User user)
	{
		return new ModelAndView("Login");
	}
	
	@RequestMapping(value="/LoginAttempt", method = RequestMethod.POST)
	public ModelAndView loginAttempt(@ModelAttribute("user") User user, ModelMap model)
	{
		ModelAndView modelview = null;
		
		user = userdao.getValidUser(user);
		if(user != null)
		{
			if(user.getRole().equals("ROLE_USER"))
			{
				modelview = new ModelAndView("UserHome");
				modelview.addObject("email", user.getEmail());
			}
			else if(user.getRole().equals("ROLE_ADMIN"))
			{
				modelview = new ModelAndView("AdminHome");
			}
		}
		else
		{
			modelview = new ModelAndView("InvalidCredentials");
		}


		return modelview;
	}
}

