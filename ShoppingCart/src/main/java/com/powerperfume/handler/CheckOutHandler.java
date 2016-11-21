package com.powerperfume.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.Order;
import com.powerperfume.model.Product;
import com.powerperfume.model.User;

@Component
public class CheckOutHandler {
		@Autowired
		UserDAO userDAO;

		public User getInstance(RequestContext context)
		{
			HttpSession session = ((HttpServletRequest) context.getExternalContext().getNativeRequest()).getSession();
			User user = userDAO.get((String) session.getAttribute("email"));
			return user;
		}

		public void getCart(RequestContext context)
		{
			HttpSession session = ((HttpServletRequest) context.getExternalContext().getNativeRequest()).getSession();
			String email = (String) session.getAttribute("email");
			BigDecimal total = new BigDecimal(0);
			List<Order> orderList = userDAO.get(email).getOrders();
			List<Order> orderList2 = new ArrayList<Order>();
			List<Product> productList = new ArrayList<Product>();
			for(Order o : orderList)
			{
				if(o.getStatus().equals("PENDING"))
				{
					orderList2.add(o);
					productList.add(o.getProduct());
					total = total.add(o.getProduct().getPrice().multiply(new BigDecimal(o.getQuantity())));
				}
			}
			session.setAttribute("orderList", orderList2);
			session.setAttribute("productList", productList);
			session.setAttribute("total", total);
		}

		public void orderConfirm(RequestContext context)
		{
			HttpSession session = ((HttpServletRequest) context.getExternalContext().getNativeRequest()).getSession();
			String email = (String) session.getAttribute("email");
			User user = userDAO.get(email);
			List<Order> orderList = user.getOrders();
			for(Order o : orderList)
				o.setStatus("PROCESSING");
			userDAO.update(user);
		}

}
