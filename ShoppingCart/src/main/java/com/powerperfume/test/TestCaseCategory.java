package com.powerperfume.test;

import static org.junit.Assert.*;


import java.util.List;


import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.model.Category;

public class TestCaseCategory {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.powerperfume");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");		
	}


	@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDAO.list(0);		
		assertEquals("Category List Test Case", 5, list.size());
	}
	
	@Test
	public void categoryAddTestCase()
	{
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
	public void categoryGetTestCase()
	{
		category = categoryDAO.get("0");
		assertNotNull(category);
		assertEquals("Get Category", "Shirts", category.getName());
	}
	
	@Test
	public void categoryDeleteTestCase()
	{
		assertEquals("Delete Category", true, categoryDAO.delete("C08"));
	}
}
