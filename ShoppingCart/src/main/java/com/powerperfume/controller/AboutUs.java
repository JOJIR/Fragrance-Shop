package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUs {
	@RequestMapping("/AboutUS")
	public String ShowAboutUS()
	{
		return "ABoutUS";
	}

}
