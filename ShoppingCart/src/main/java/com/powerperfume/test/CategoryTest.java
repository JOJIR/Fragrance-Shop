package com.powerperfume.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.model.Category;

public class CategoryTest {
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.powerperfume");
		        context.refresh();
		         
		        CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		        Category category = (Category) context.getBean("category");
		        category.setId("C007");
		        category.setName("CG007");
		        category.setDescription("CG007 Descr");
		        
		       if(categoryDAO.save(category) == true)
		       {
		    	   System.out.println("category created successfully");
		       }
		       else
		       {
		    	   System.out.println("not able to create the category");
		       }
		        	
		    
		        		
		        		
		        		
		       
		
	}
	
}
