package com.powerperfume.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.dao.ProductDAO;
import com.powerperfume.dao.SupplierDAO;
import com.powerperfume.model.Category;
import com.powerperfume.model.Product;
import com.powerperfume.model.Supplier;

@Controller
public class AdminController
{
	@Autowired
	CategoryDAO categoryDAO;


	@Autowired
	SupplierDAO supplierDAO;


	@Autowired
	ProductDAO productDAO;


	@RequestMapping("/AdminHome")
	public String adminHome()
	{
		return "AdminHome";
	}


	@RequestMapping("/AddProduct")
	public ModelAndView addProduct(@ModelAttribute("product") Product product)
	{
		ModelAndView modelView = new ModelAndView("AddProduct");
		List<Category> clist = categoryDAO.list(0);
		List<Supplier> slist = supplierDAO.list(0);


		Map<String, String> cmap = new LinkedHashMap<String, String>();
		Map<Integer, String> smap = new LinkedHashMap<Integer, String>();


		for (Category c : clist)
			cmap.put(c.getId(), c.getName());
		for (Supplier s : slist)
			smap.put(s.getId(), s.getName());


		modelView.addObject("categoryList", cmap);
		modelView.addObject("supplierList", smap);


		return modelView;
	}


	@RequestMapping("/AddProductAttempt")
	public String addProductAttempt(@ModelAttribute("product") Product product, HttpServletRequest request, Model model)
	{
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("./resources/image/products/" + product.getId() + ".jpg");


		System.out.println("Path = " + path);
		System.out.println("File name = " + product.getImage().getOriginalFilename());


		if (!product.getImage().isEmpty())
		{
			try
			{
				File f = new File(path);
				f.createNewFile();
				byte[] bytes = product.getImage().getBytes();
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(bytes);
				bs.close();
				System.out.println("Image uploaded");
			} catch (Exception e)
			{
				System.out.println("Exception occured while uploading image: " + e);
			}
		}


		productDAO.save(product);


		return "redirect:/AdminProductList";
	}


	@RequestMapping("/EditProduct")
	public ModelAndView editProduct(@RequestParam("id") String id)
	{
		ModelAndView modelView = new ModelAndView("EditProduct");
		List<Category> clist = categoryDAO.list(0);
		List<Supplier> slist = supplierDAO.list(0);


		Map<String, String> cmap = new LinkedHashMap<String, String>();
		Map<Integer, String> smap = new LinkedHashMap<Integer, String>();


		for (Category c : clist)
			cmap.put(c.getId(), c.getName());
		for (Supplier s : slist)
			smap.put(s.getId(), s.getName());


		modelView.addObject("product", productDAO.get(id));
		modelView.addObject("categoryList", cmap);
		modelView.addObject("supplierList", smap);


		return modelView;
	}
	
	@RequestMapping("/EditProductAttempt")
	public String editProductAttempt(@ModelAttribute("product") Product product, HttpServletRequest request, Model model)
	{
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("./resources/image/products/" + product.getId() + ".jpg");


		System.out.println("Path = " + path);
		System.out.println("File name = " + product.getImage().getOriginalFilename());


		if (!product.getImage().isEmpty())
		{
			try
			{
				File f = new File(path);
				f.createNewFile();
				byte[] bytes = product.getImage().getBytes();
				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(bytes);
				bs.close();
				System.out.println("Image uploaded");
			} catch (Exception e)
			{
				System.out.println("Exception occured while uploading image: " + e);
			}
		}


		productDAO.update(product);


		return "redirect:/AdminProductList";
	}


	@RequestMapping("/DeleteProductAttempt")
	public String deleteProductAttempt(@RequestParam("id") String id, Model model)
	{
		productDAO.delete(id);
		return "redirect:/AdminProductList";
	}


	@RequestMapping("/AddSupplier")
	public ModelAndView addSupplier(@ModelAttribute("supplier") Supplier supplier)
	{
		ModelAndView modelView = new ModelAndView("AddSupplier");
		return modelView;
	}


	@RequestMapping("/AddSupplierAttempt")
	public String addSupplierAttempt(@ModelAttribute("supplier") Supplier supplier, Model model)
	{
		supplierDAO.save(supplier);
		return "redirect:/AdminSupplierList";
	}


	@RequestMapping("/AdminProductList")
	public ModelAndView adminProductList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		ModelAndView modelView = new ModelAndView("AdminProductList");
		int s = 0;
		if (sort != null)
			s = sort;
		List<Product> productList = productDAO.list(s);
		modelView.addObject("productList", productList);
		modelView.addObject("sortOrder", s);
		return modelView;
	}


	@RequestMapping("/AdminSupplierList")
	public ModelAndView adminSupplierList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		ModelAndView modelView = new ModelAndView("AdminSupplierList");
		int s = 0;
		if (sort != null)
			s = sort;
		List<Supplier> supplierList = supplierDAO.list(s);
		modelView.addObject("supplierList", supplierList);
		modelView.addObject("sortOrder", s);
		return modelView;
	}
}


