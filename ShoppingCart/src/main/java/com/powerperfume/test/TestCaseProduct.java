package com.powerperfume.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.ProductDAO;
import com.powerperfume.model.Product;

public class TestCaseProduct {
	

		@Autowired
		ProductDAO productDAO;
	

		@Autowired
		Product product;
	

		@Autowired
		AnnotationConfigApplicationContext context;
	

		@Before
		public void init()
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com.powerperfume");
			context.refresh();
	

			productDAO = (ProductDAO) context.getBean("productDAO");
			product = (Product) context.getBean("product");
		}
	

		@Test
		public void addProductTestCase()
		{
			product.setId("MOB_004");
			product.setName("samsung");
			product.setDescription("samsung desc");
			product.setPrice(BigDecimal.valueOf(16000));
	

			assertEquals("Add Product", true, productDAO.save(product));
		}
		
		@Test
		public void listProductTestCase()
		{
			assertEquals("List Product", 1, productDAO.list(0).size());
		}
	

		@Test
		public void updateProductTestCase()
		{
			product.setId("MOB_004");
			product.setName("htc");
			product.setPrice(BigDecimal.valueOf(64000));
			product.setDescription("htc desc");
	

			assertEquals("Update Product", true, productDAO.update(product));
		}
	

		@Test
		public void getProductTestCase()
		{
			assertNotNull(productDAO.get("MOB_004"));
		}
		
		@Test
		public void deleteProductTestCase()
		{
			assertEquals("Delete Product", true, productDAO.delete("MOB_004"));
		}
	}

