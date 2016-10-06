package com.powerperfume.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	HttpSession session;
	
	@Autowired
	CategoryDAO categoryDAO;


	@Autowired
	SupplierDAO supplierDAO;


	@Autowired
	ProductDAO productDAO;


	@RequestMapping("/AdminHome")
	public String adminHome()
	{
		if (session.getAttribute("isAdmin") != null)
		return "admin/AdminHome";
		
		return "redirect:/AccountHome";
	}

	@RequestMapping("/AccountHome")
	public String accountHome()
	{
		if(session.getAttribute("isAdmin") !=null)
			return "redirect:/AdminHome";
		else if(session.getAttribute("isLoggedin") !=null)
			
			return "redirect:/UserHome";
			
			return "redirect:/Login";
	}
	
	@RequestMapping("/AddProduct")
	public ModelAndView addProduct()
	{
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
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
		modelView.addObject("product", new Product());
		modelView.addObject("isAdminAddProductClicked", true);


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
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
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
		modelView.addObject("isAdminEditProductClicked", true);
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
	public ModelAndView addSupplier()
	{
		ModelAndView modelView;
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			
			modelView.addObject("isAdminAddSupplierClicked", true);
			modelView.addObject("supplier", new Supplier());
		}
		else
			modelView = new ModelAndView("../../index");
		
		return modelView;
	}


	@RequestMapping("/AddSupplierAttempt")
	public String addSupplierAttempt(@ModelAttribute("supplier") Supplier supplier, Model model)
	{
		supplierDAO.save(supplier);
		return "redirect:/AdminSupplierList";
	}


	@RequestMapping("/EditSupplier")
	public ModelAndView editSupplier(@RequestParam("id") Integer id)
	{
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
		modelView.addObject("supplier", supplierDAO.get(id));
		modelView.addObject("isAdminEditSupplierClicked", true);
		
		return modelView;
	}
	
	@RequestMapping("/EditSupplierAttempt")
	public String editSupplierAttempt(@ModelAttribute("supplier") Supplier supplier, Model model)
	{
		supplierDAO.update(supplier);
		return "redirect:/AdminSupplierList";
	}
	
	@RequestMapping("DeleteSupplierAttempt")
	public String deleteSupplierAttempt(@RequestParam("id") Integer id)
	{
		supplierDAO.delete(id);
		return "redirect:/AdminSupplierList";
	}
	
	@RequestMapping("/AddCategory")
	public ModelAndView addCategory()
	{
		ModelAndView modelView;
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminAddCategoryClicked", true);
			modelView.addObject("category", new Category());
			
		}
		else
			modelView = new ModelAndView("../../index");
		
		return modelView;
	}
	
	@RequestMapping("/AddCategoryAttempt")
	public String addCategoryAttempt(@ModelAttribute("Category") Category Category, Model model)
	{
		categoryDAO.save(Category);
		return "redirect:/AdminCategoryList";
	}
	
	@RequestMapping("/EditCategory")
	public ModelAndView editCategory(@RequestParam("id") String id)
	{
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
		modelView.addObject("category", categoryDAO.get(id));
		modelView.addObject("isAdminEditcategoryClicked", true);
		
		return modelView;
	}
	
	@RequestMapping("EditCategoryAttempt")
	public String editCategoryAttempt(@ModelAttribute("category") Category category, Model model)
	{
		categoryDAO.update(category);
		return "redirect:/AdminCategoryList";
	}
	
	@RequestMapping("/DeleteCategoryAttempt")
	public String deleteCategoryAttempt(@RequestParam("id") String id)
	{
		categoryDAO.delete(id);
		return "redirect:/AdminCategoryList";
	}
	
	
	@RequestMapping("/AdminProductList")
	public ModelAndView adminProductList(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
		int s = sort != null ? sort : 0;
		List<Product> productList;
		if (category == null)
			productList = productDAO.list(s);
		else
		{
			productList = productDAO.listByCategory(category, s);
			model.addAttribute("categoryQuery", "\"category=" + category + "&\" +");
		}
			
			modelView.addObject("maleCategoryList", categoryDAO.listFlag(true, 0));
			modelView.addObject("femaleCategoryList", categoryDAO.listFlag(false, 0));
			modelView.addObject("productList", productList);
			modelView.addObject("sortOrder", s);
			modelView.addObject("isAdminViewProductsClicked", true);
			
			return modelView;
		}
			
	
	

	@RequestMapping("/AdminSupplierList")
	public ModelAndView adminSupplierList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		ModelAndView modelView;
		int s = sort != null ? sort : 0;
		
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminViewSupplierClicked", true);
			modelView.addObject("supplierList", supplierDAO.list(s));
			modelView.addObject("sortOrder", s);
		}
		else
			modelView =new ModelAndView("../../index");
		
		return modelView;
	}
	
	@RequestMapping("/AdminCategoryList")
	public ModelAndView adminCategoryList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		ModelAndView modelView;
		int s = sort != null ? sort : 0;
		
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminViewCategoriesClicked", true);
			modelView.addObject("categoryList", categoryDAO.list(s));
			modelView.addObject("sortOrder", s);
		}
		else
			modelView = new ModelAndView("../../index");
		
		return modelView;
	}
}


