package com.powerperfume.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.powerperfume.dao.OrderDAO;
import com.powerperfume.dao.ProductDAO;
import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.Order;
import com.powerperfume.model.Product;
import com.powerperfume.model.User;

@Controller
public class CartController {
	
	@Autowired
	Order order;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/AddToCart")
	public String addToCart(@RequestParam("id") String id, ModelMap model)
	{
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			User user = userDAO.get(email);
			order.setUser(user);
			order.setProduct(productDAO.get(id));
			order.setQuantity(1);
			order.setStatus("PENDING");
			user.getOrders().add(order);
			userDAO.update(user);
			
			return "redirect:/Cart";
		}
		return "redirect:/Login";
	}
	
	@RequestMapping("/UpdateCart")
	public String updateCart(@RequestParam("id") int id, @RequestParam("quantity") int quantity, ModelMap model)
	{
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			Order o = orderDAO.get(id);
			o.setQuantity(quantity);
			orderDAO.update(o);
			
			return "redirect:/Cart";
			}
		return "redirect:/Login";
	}
	
	
	@RequestMapping("/RemoveFromCart")
	public String removeFromCart(@RequestParam("id") int id, ModelMap model)
	{
		String email = (String) session.getAttribute("email");
				if(email != null)
				{
					User user = userDAO.get(email);
					Order o = orderDAO.get(id);
					user.getOrders().remove(0);
					userDAO.update(user);
					
					return "redirect:/Cart";
				}
				return "redirect:/Login";
				
	}
	
	@RequestMapping("/Cart")
	public String cart(ModelMap model)
	{
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			BigDecimal total = new BigDecimal(0);
			List<Order> orderList = userDAO.get(email).getOrders();
			List<Product> productList = new ArrayList<Product>();
			for(Order o : orderList) 
				{
				productList.add(o.getProduct());
				total = total.add(o.getProduct().getPrice().multiply(new BigDecimal(o.getQuantity())));
				}
			model.addAttribute("orderList", orderList);
			model.addAttribute("productList", productList);
			model.addAttribute("total", total);
			
			return "user/Cart";
		}
			
			return "redirect:/Login";
		
	}
	

}