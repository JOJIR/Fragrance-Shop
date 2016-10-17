package com.powerperfume.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
	
	Logger log = LoggerFactory.getLogger(AboutUsController.class);
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/AboutUs")
	public String aboutUs()
	{
		log.debug("MethodStart: aboutUs");
		log.debug("MethodEnd: aboutUs");

		
		return "user/AboutUs";
	}

}
