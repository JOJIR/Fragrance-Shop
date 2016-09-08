package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Registercontroller {
	@RequestMapping ("/Register")
	public String ShowRegister()
	{
		return "Register";
	}

}
