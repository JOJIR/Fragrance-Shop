package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Aboutuscontroller {
	@RequestMapping("/AboutUs")
	public String ShowAboutUs()
	{
		return "AboutUs";
	}
}
