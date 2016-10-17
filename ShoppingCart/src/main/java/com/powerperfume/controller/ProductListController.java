package com.powerperfume.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger log = LoggerFactory.getLogger(ProductListController.class);
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;


	@RequestMapping("/SingleProduct")
	String singleProduct(@RequestParam("id") String id, ModelMap model)
	{
		Product p = productDAO.get(id);
		model.addAttribute("product", p);
		return "user/SingleProduct";
	}

	
	@RequestMapping("/ProductGrid")
	String productGrid(@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "sort", required = false) Integer sort, ModelMap model) 
	{
		log.debug("MethodStart: productGrid");
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

		log.debug("MethodEnd: productGrid");
		
		return "user/ProductGrid";
	}

	@RequestMapping("/ProductList")
	String productList(@RequestParam(value ="category", required = false) String category, 
			@RequestParam(value = "sort", required = false) Integer sort, ModelMap model) 
	{
		log.debug("MethodStart: productList");
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
		
		log.debug("MethodEnd: productList");
		
		return "user/ProductList";
	}
}
