package com.powerperfume.dao;

import java.util.List;

public interface Productdao {
	public List<Product> list();
	public void get(String id);
	public void saveOrUpdate(Product product);
	public void delete(String id);

}
