package com.powerperfume.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.Order;
import com.powerperfume.model.Product;
import com.powerperfume.model.User;


@Controller
public class LoginController{

	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/Login")
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model)
	{
		log.debug("MethodStart: login");
		if(error != null)
		{
			model.addAttribute("invalidCredentials", true);
		
		log.info("Invalid Credentials");
		}
		log.debug("MethodEnd: login");
		
		return "user/Login";
	}
	
	@RequestMapping(value="/LoginAttempt")
	public ModelAndView loginAttempt(Principal p, ModelMap model)
	{
		log.debug("MethodStart: loginAttempt");
		ModelAndView modelView = null;
		
		User user = userDAO.get(p.getName());
		if(user != null)
		{
			if(user.getRole().equals("ROLE_USER"))
			{
				modelView = new ModelAndView("redirect:/UserHome");
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("email", user.getEmail());
				log.debug("MethodEnd: loginAttempt-UserHome");
			}
			else 
				if(user.getRole().equals("ROLE_ADMIN"))
			{
				modelView = new ModelAndView("admin/AdminHome");
				session.setAttribute("isLoggedIn", true);
				session.setAttribute("isAdmin", true);
				session.setAttribute("email", user.getEmail());
				log.debug("MethodEnd: loginAttempt-AdminHome");
			}
		}
		else
		{
			session.setAttribute("isLoggedIn", false);
			session.setAttribute("isAdmin", false);
			modelView = new ModelAndView("user/Login");
			modelView.addObject("invalidCredentials", true);
			log.debug("MethodEnd: loginAttempt-Login");
		}


		return modelView;
	}
	
	@RequestMapping("/UserHome")
	public String userHome(ModelMap model)
	{
		log.debug("MethodStart: userHome");
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			User user = userDAO.get(email);
			List<Order> orderList = user.getOrders();
			List<Order> orderList2 = new ArrayList<Order>();
			List<Product> productList = new ArrayList<Product>();
			for(Order o : orderList)
			{
				if(!o.getStatus().equals("PENDING"))
				{
					orderList2.add(o);
					productList.add(o.getProduct());
				}
			}
			model.addAttribute("user", user);
			model.addAttribute("orderList2", orderList2);
			model.addAttribute("productList2", productList);

			log.debug("MethodEnd: userHome-UserHome");

			return "user/UserHome";
		}

		log.debug("MethodEnd: userHome-Login");

		return "redirect:/Login";
	}

	
	@RequestMapping(value = "/LogOut")
	public String logout(HttpServletRequest request)
	{
		log.debug("MethodStart: logout");
		session.invalidate();
		session = request.getSession();
		log.debug("MethodEnd: logout");
		
		return "redirect:/Home";
	}

}

