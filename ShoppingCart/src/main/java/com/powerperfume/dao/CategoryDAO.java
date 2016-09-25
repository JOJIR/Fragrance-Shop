package com.powerperfume.dao;



import java.util.List;

import com.powerperfume.model.Category;

public interface CategoryDAO {


	public List<Category> list(int sortOrder);

	public Category get(String id);
	
	public boolean update(Category category);

	public boolean save(Category category);

	public boolean delete(String id);


}