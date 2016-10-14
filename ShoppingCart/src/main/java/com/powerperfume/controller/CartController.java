package com.powerperfume.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	
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
		log.debug("MethodStart: addToCart");
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			log.info("Email:" + email);
			User user = userDAO.get(email);
			Order o = new Order();
			o.setUser(user);
			o.setProduct(productDAO.get(id));
			o.setQuantity(1);
			o.setStatus("PENDING");
			user.getOrders().add(o);
			userDAO.update(user);
			log.debug("MethodEnd: addToCart-Cart");
			
			return "redirect:/Cart";
		}
		
		log.debug("MethodEnd: addToCart-Login");
		
		return "redirect:/Login";
	}
	
	@RequestMapping("/UpdateCart")
	public String updateCart(@RequestParam("id") int id, @RequestParam("quantity") int quantity, ModelMap model)
	{
		log.debug("MethodStart: updateCart");
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			log.info("Email:" + email);
			Order o = orderDAO.get(id);
			o.setQuantity(quantity);
			log.info("Order in updateCart:" + o.toString());
			orderDAO.update(o);
			log.debug("MethodEnd: updateCart-Cart");
			
			return "redirect:/Cart";
			}
		
		log.debug("MethodEnd: updateCart-Login");
		
		return "redirect:/Login";
	}
	
	
	@RequestMapping("/RemoveFromCart")
	public String removeFromCart(@RequestParam("id") int id, ModelMap model)
	{
		log.debug("MethodStart: removeFromCart");
		String email = (String) session.getAttribute("email");
				if(email != null)
				{
					log.info("Email:" + email);
					User user = userDAO.get(email);
					Order o = orderDAO.get(id);
					user.getOrders().remove(0);
					userDAO.update(user);
					log.debug("MethodEnd: removeFromCart-Cart");
					
					return "redirect:/Cart";
				}
				
				log.debug("MethodEnd: removeFromCart-Login");
				
				return "redirect:/Login";
				
	}
	
	@RequestMapping("/Cart")
	public String cart(ModelMap model)
	{
		log.debug("MethodStart: cart");
		String email = (String) session.getAttribute("email");
		if(email != null)
		{
			log.info("Email:" + email);
			BigDecimal total = new BigDecimal(0);
			List<Order> orderList = userDAO.get(email).getOrders();
			List<Order> orderList2 = new ArrayList<Order>();
			List<Product> productList = new ArrayList<Product>();
			for(Order o : orderList) 
				{
					if(o.getStatus().equals("PENDING"))
					{
					log.info("Adding order to Cart:" + o);
					orderList2.add(o);
					productList.add(o.getProduct());
					total = total.add(o.getProduct().getPrice().multiply(new BigDecimal(o.getQuantity())));
					}
				}
			session.setAttribute("orderList", orderList2);
			session.setAttribute("productList", productList);
			session.setAttribute("total", total);
			log.debug("MethodEnd: cart-Cart");
			
			return "user/Cart";
		}
			
		log.debug("MethodEnd: cart-Login");
		
		return "redirect:/Login";
		
	}
	

}