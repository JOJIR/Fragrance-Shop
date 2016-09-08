package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Contactuscontroller {
	@RequestMapping("/ContactUs")
	public String ShowContactUs()
	{
		return "ContactUs";
	}

}
