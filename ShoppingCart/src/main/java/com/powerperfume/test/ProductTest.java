package com.powerperfume.test;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.ProductDAO;
import com.powerperfume.model.Product;

public class ProductTest {
	
	public static void main(String[] args)
	{
	
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.powerperfume");
			context.refresh();


			ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
			Product product = (Product) context.getBean("product");
			product.setId("MOB_004");
			product.setName("samsung");
			product.setPrice(BigDecimal.valueOf(16000));
			product.setDescription("samsung desc");


			if (productDAO.save(product))
				System.out.println("product created successfully");
			else
				System.out.println("not able to create the product");
			
			
			
			context.close();
		}
}
