package com.powerperfume.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/Home")
	public String home()
	{
		log.debug("MethodStart: home");
		log.debug("MethodEnd: home");
		
		return "user/index";
	}
	
	
}
