package com.powerperfume.dao;

import java.util.List;

import com.powerperfume.model.Product;

public interface ProductDAO {


	public List<Product> list(int sortOrder);
	
	public List<Product> listByCategory(int categoryID, int sortOrder);

	public Product get(String id);

	public boolean save(Product product);
	
	public boolean update(Product product);

	public boolean delete(String id);


}

