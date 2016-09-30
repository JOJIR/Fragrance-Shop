package com.powerperfume.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.powerperfume.dao.SupplierDAO;
import com.powerperfume.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args)
	{


		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.powerperfume");
		context.refresh();


		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setName("Supplier004");
		supplier.setAddress("address");


		if (supplierDAO.save(supplier))
			System.out.println("supplier created successfully");
		else
			System.out.println("not able to create the supplier");
		
		
		
		context.close();
	}
}

