package com.powerperfume.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleProductController {
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/SingleProduct")
	public String singleProduct()
	{
		return "user/SingleProduct";
	}

}
