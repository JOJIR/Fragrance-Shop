package com.powerperfume.test;

import static org.junit.Assert.*;


import java.util.List;



import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.model.Category;




public class TestCaseCategory {
	
		
		@Autowired
		static
		CategoryDAO categoryDAO;
		
		@Autowired
		static
		Category category;
		
		@Autowired
		static
		AnnotationConfigApplicationContext context;
		
		@BeforeClass
		public static void init()
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com.powerperfume");
			context.refresh();
			
			categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
			category = (Category) context.getBean("category");		
		}
	

		@Test
		public void categoryAddTestCase()
		{
			category = (Category) context.getBean("category");		
			category.setId("C08");
			category.setName("Category08");
			category.setDescription("TestDesc08");
			
			assertEquals("Create Category", true, categoryDAO.save(category));
		}
		
		@Test
		public void categoryUpdateTestCase()
		{
			category.setId("C08");
			category.setName("Category16");
			category.setDescription("TestDesc16");
			
			assertEquals("Update Category", true, categoryDAO.update(category));
		}
		
		@Test
		public void categoryListTestCase()
		{
			List<Category> list = categoryDAO.list(0);		
			assertEquals("Category List Test Case", 7, list.size());
		}
		
		
		@Test
		public void categoryGetTestCase()
		{
			category = categoryDAO.get("C08");
			assertNotNull(category);
			assertEquals("Get Category", "Fragrance Men", category.getName());
		}
		@Test
		public void categoryDeleteTestCase()
		{
			assertEquals("Delete Category", true, categoryDAO.delete("C08"));
		}
		
		
		
	}

