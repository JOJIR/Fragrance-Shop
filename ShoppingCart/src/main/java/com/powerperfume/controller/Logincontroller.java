package com.powerperfume.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/Login")
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model)
	{
		if(error != null)
			model.addAttribute("invalidCredentials", true);
		
		return "user/Login";
	}
	
	@RequestMapping(value="/LoginAttempt")
	public ModelAndView loginAttempt(Principal p, ModelMap model)
	{
		ModelAndView modelView = null;
		
		User user = userDAO.get(p.getName());
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
				session.setAttribute("isLoggedIn", true);
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
	public String userHome(ModelMap model)
	{
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


			return "user/UserHome";
		}


		return "redirect:/Login";
	}

	
	@RequestMapping(value = "/LogOut")
	public String logout(HttpServletRequest request)
	{
		session.invalidate();
		session = request.getSession();
		return "redirect:/Home";
	}

}

