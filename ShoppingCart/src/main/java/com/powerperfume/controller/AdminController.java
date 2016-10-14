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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger log = LoggerFactory.getLogger(CartController.class);
	
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
		log.debug("MethodStart: adminHome");
		if (session.getAttribute("isAdmin") != null)
		{
		
			return "admin/AdminHome";
		
		
		}
	log.debug("MethodEnd: adminHome");
	
	return "redirect:/AccountHome";
	
	}
	
	
	@RequestMapping("/Error")
	public String accessDenied()
	{
		log.debug("MethodStart: accessDenied");
		log.debug("MethodEnd: accessDenied");

		
		return "Error";
	}


	@RequestMapping("/AccountHome")
	public String accountHome()
	{
		log.debug("MethodStart: accountHome");
		if(session.getAttribute("isAdmin") !=null)
		{
			log.debug("MethodEnd: accountHome");
			
			return "redirect:/AdminHome";
		}
			
		else if(session.getAttribute("isLoggedin") !=null)
			
		{
			log.debug("MethodEnd: accountHome");
			
			return "redirect:/UserHome";
			
			
	}
		log.debug("MethodEnd: accountHome");
		
		return "redirect:/Login";
		
	}
	
	@RequestMapping("/AddProduct")
	public ModelAndView addProduct()
	{
		log.debug("MethodStart: addProduct");
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


		log.debug("MethodEnd: addProduct");
		
		return modelView;
	}


	@RequestMapping("/AddProductAttempt")
	public String addProductAttempt(@ModelAttribute("product") Product product, HttpServletRequest request, Model model)
	{
		log.debug("MethodStart: addProductAttempt");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("./resources/image/products/" + product.getId() + ".jpg");


		log.info("Path = " + path);
		log.info("File name = " + product.getImage().getOriginalFilename());


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
				log.info("Image uploaded");
			} catch (Exception e)
			{
				log.error("Exception occured while uploading image: " + e);
			}
		}


		productDAO.save(product);
		log.debug("MethodEnd: addProductAttempt");

		return "redirect:/AdminProductList";
	}


	@RequestMapping("/EditProduct")
	public ModelAndView editProduct(@RequestParam("id") String id)
	{
		log.debug("MethodStart: editProduct");
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
		
		log.debug("MethodEnd: editProduct");
		
		return modelView;
	}
	
	@RequestMapping("/EditProductAttempt")
	public String editProductAttempt(@ModelAttribute("product") Product product, HttpServletRequest request, Model model)
	{
		log.debug("MethodStart: editProductAttempt");
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("./resources/image/products/" + product.getId() + ".jpg");


		log.info("Path = " + path);
		log.info("File name = " + product.getImage().getOriginalFilename());


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
				log.info("Image uploaded");
			} catch (Exception e)
			{
				log.error("Exception occured while uploading image: " + e);
			}
		}


		productDAO.update(product);
		log.debug("MethodEnd: editProductAttempt");

		return "redirect:/AdminProductList";
	}


	@RequestMapping("/DeleteProductAttempt")
	public String deleteProductAttempt(@RequestParam("id") String id, Model model)
	{
		log.debug("MethodStart: deleteProductAttempt");
		productDAO.delete(id);
		log.debug("MethodEnd: deleteProductAttempt");
		
		return "redirect:/AdminProductList";
	}


	@RequestMapping("/AddSupplier")
	public ModelAndView addSupplier()
	{
		log.debug("MethodStart: addSupplier");
		ModelAndView modelView;
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminAddSupplierClicked", true);
			modelView.addObject("supplier", new Supplier());
		}
		else
			modelView = new ModelAndView("../../index");
		
		log.debug("MethodEnd: addSupplier");
		
		return modelView;
	}


	@RequestMapping("/AddSupplierAttempt")
	public String addSupplierAttempt(@ModelAttribute("supplier") Supplier supplier, Model model)
	{
		log.debug("MethodStart: addSupplierAttempt");
		supplierDAO.save(supplier);
		log.debug("MethodEnd: addSupplierAttempt");
		
		return "redirect:/AdminSupplierList";
	}


	@RequestMapping("/EditSupplier")
	public ModelAndView editSupplier(@RequestParam("id") Integer id)
	{
		log.debug("MethodStart: editSupplier");
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
		modelView.addObject("supplier", supplierDAO.get(id));
		modelView.addObject("isAdminEditSupplierClicked", true);
		
		log.debug("MethodEnd: editSupplier");
		
		return modelView;
	}
	
	@RequestMapping("/EditSupplierAttempt")
	public String editSupplierAttempt(@ModelAttribute("supplier") Supplier supplier, Model model)
	{
		log.debug("MethodStart: editSupplierAttempt");
		supplierDAO.update(supplier);
		log.debug("MethodEnd: editSupplierAttempt");
		
		return "redirect:/AdminSupplierList";
	}
	
	@RequestMapping("DeleteSupplierAttempt")
	public String deleteSupplierAttempt(@RequestParam("id") Integer id)
	{
		log.debug("MethodStart: deleteSupplierAttempt");
		supplierDAO.delete(id);
		log.debug("MethodEnd: deleteSupplierAttempt");
		
		return "redirect:/AdminSupplierList";
	}
	
	@RequestMapping("/AddCategory")
	public ModelAndView addCategory()
	{
		log.debug("MethodStart: addCategory");
		ModelAndView modelView;
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminAddCategoryClicked", true);
			modelView.addObject("category", new Category());
			
		}
		else
			modelView = new ModelAndView("../../index");
		
		log.debug("MethodEnd: addCategory");
		
		return modelView;
	}
	
	@RequestMapping("/AddCategoryAttempt")
	public String addCategoryAttempt(@ModelAttribute("Category") Category Category, Model model)
	{
		log.debug("MethodStart: addCategoryAttempt");
		categoryDAO.save(Category);
		log.debug("MethodEnd: addCategoryAttempt");
		
		return "redirect:/AdminCategoryList";
	}
	
	@RequestMapping("/EditCategory")
	public ModelAndView editCategory(@RequestParam("id") String id)
	{
		log.debug("MethodStart: editCategory");
		ModelAndView modelView = new ModelAndView("admin/AdminHome");
		modelView.addObject("category", categoryDAO.get(id));
		modelView.addObject("isAdminEditCategoryClicked", true);
		log.debug("MethodEnd: editCategory");
		
		
		return modelView;
	}
	
	@RequestMapping("EditCategoryAttempt")
	public String editCategoryAttempt(@ModelAttribute("category") Category category, Model model)
	{
		log.debug("MethodStart: editCategoryAttempt");
		categoryDAO.update(category);
		log.debug("MethodEnd: editCategoryAttempt");
		
		return "redirect:/AdminCategoryList";
	}
	
	@RequestMapping("/DeleteCategoryAttempt")
	public String deleteCategoryAttempt(@RequestParam("id") String id)
	{
		log.debug("MethodStart: deleteCategoryAttempt");
		categoryDAO.delete(id);
		log.debug("MethodEnd: deleteCategoryAttempt");
		
		return "redirect:/AdminCategoryList";
	}
	
	
	@RequestMapping("/AdminProductList")
	public ModelAndView adminProductList(@RequestParam(value = "category", required = false) String category, @RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		log.debug("MethodStart: adminProductList");
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
			
			log.debug("MethodEnd: adminProductList");
			
			return modelView;
		}
			
	
	

	@RequestMapping("/AdminSupplierList")
	public ModelAndView adminSupplierList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		log.debug("MethodStart: adminSupplierList");
		ModelAndView modelView;
		int s = sort != null ? sort : 0;
		
		if(session.getAttribute("isAdmin") != null)
		{
			modelView = new ModelAndView("admin/AdminHome");
			modelView.addObject("isAdminViewSuppliersClicked", true);
			modelView.addObject("supplierList", supplierDAO.list(s));
			modelView.addObject("sortOrder", s);
		}
		else
			modelView =new ModelAndView("../../index");
		
		log.debug("MethodEnd: adminSupplierList");
		
		return modelView;
	}
	
	@RequestMapping("/AdminCategoryList")
	public ModelAndView adminCategoryList(@RequestParam(value = "sort", required = false) Integer sort, ModelMap model)
	{
		log.debug("MethodStart: adminCategoryList");
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
		
		log.debug("MethodEnd: adminCategoryList");
		
		return modelView;
	}
}


