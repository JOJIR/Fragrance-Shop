package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{	
	@RequestMapping("/Home")
	public String home()
	{
		return "../../index";
	}
	
	
}