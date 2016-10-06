package com.powerperfume.controller;

import javax.servlet.http.HttpServletRequest;
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
public class LoginController{

	@Autowired
	UserDAO userdao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/Login")
	public ModelAndView login(@ModelAttribute User user)
	{
		return new ModelAndView("user/Login");
	}
	
	@RequestMapping(value="/LoginAttempt", method = RequestMethod.POST)
	public ModelAndView loginAttempt(@ModelAttribute User user, ModelMap model)
	{
		ModelAndView modelView = null;
		
		user = userdao.getValidUser(user);
		if(user != null)
		{
			if(user.getRole().equals("ROLE_USER"))
			{
				modelView = new ModelAndView("user/UserHome");
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("email", user.getEmail());
			}
			else 
				if(user.getRole().equals("ROLE_ADMIN"))
			{
				modelView = new ModelAndView("admin/AdminHome");
				session.setAttribute("isAdmin", true);
				session.setAttribute("email", user.getEmail());
			}
		}
		else
		{
			session.setAttribute("isLoggedIn", false);
			session.setAttribute("isAdmin", false);
			
			modelView = new ModelAndView("user/Login");
					modelView.addObject("invalidCredentials", true);
		}


		return modelView;
	}
	
	@RequestMapping("/UserHome")
	public String userHome()
	{
		if(session.getAttribute("isLoggedIn") != null)
			return "user/UserHome";
		
		return "redirect:/Login";
	}
	
	@RequestMapping(value="/LogOut")
	public String logout(HttpServletRequest request)
	{
		session.invalidate();
		session = request.getSession();
		return "redirect:/Home";
	}
}

