package com.powerperfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.dao.ProductDAO;
import com.powerperfume.model.Product;

@Controller
public class ProductListController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/ProductGrid")
	String productGrid(@RequestParam(value = "category", required = false) Integer category,
			@RequestParam(value = "sort", required = false) Integer sort, ModelMap model) 
	{
		int s = sort == null ? 0 : sort;
		List<Product> productList;
		if (category == null)
			productList = productDAO.list(s);

		else {
			productList = productDAO.listByCategory(category, s);
			model.addAttribute("categoryQuery", "\"category=" + category + "&\" +");
		}

		model.addAttribute("maleCategoryList", categoryDAO.listFlag(true, 0));

		model.addAttribute("femaleCategoryList", categoryDAO.listFlag(false, 0));

		model.addAttribute("productList", productList);

		model.addAttribute("sortOrder", s);

		return "ProductGrid";
	}

	@RequestMapping("/ProductList")
	String productList(@RequestParam(value ="category", required = false) Integer category, 
			@RequestParam(value = "sort", required = false) Integer sort, ModelMap model) 
	{
		int s = sort == null ? 0 : sort;
		List<Product> productList;
		if (category == null)
			productList = productDAO.list(s);
			
		else
		{
			productList = productDAO.listByCategory(category, s);
			
			model.addAttribute("categoryQuery", "\"category=" + category + "&\" +");
		}
		
		model.addAttribute("maleCategoryList", categoryDAO.listFlag(true, 0));
		
		model.addAttribute("femaleCategoryList", categoryDAO.listFlag(false, 0));
		
		model.addAttribute("productList", productList);
		
		model.addAttribute("sortOrder", s);
		
		return "ProductList";
	}
}
