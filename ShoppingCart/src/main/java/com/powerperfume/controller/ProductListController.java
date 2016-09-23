package com.powerperfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.powerperfume.dao.ProductDAO;
import com.powerperfume.model.Product;

@Controller
public class ProductListController {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/ProductList")
	String productList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		int s = 0;
		if(sort != null)
			s = sort;
		List<Product> productList = productDAO.list(s);
		model.addAttribute("productList", productList);
		model.addAttribute("sortOrder", s);
		return "ProductList";
	}
}

