package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Logincontroller {
	@RequestMapping("/Login")
	public String ShowLogin()
	{
		return "Login";
	}
}

