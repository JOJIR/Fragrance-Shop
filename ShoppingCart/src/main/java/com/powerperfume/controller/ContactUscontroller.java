package com.powerperfume.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {
	
	Logger log = LoggerFactory.getLogger(ContactUsController.class);
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/ContactUs")
	public String contactUs()
	{
		log.debug("MethodStart: contactUs");
		log.debug("MethodEnd: contactUs");

		
		return "user/ContactUs";
	}

}
