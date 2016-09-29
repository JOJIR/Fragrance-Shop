package com.powerperfume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleProductController {
	@RequestMapping("/SingleProduct")
	public String singleProduct()
	{
		return "SingleProduct";
	}

}
