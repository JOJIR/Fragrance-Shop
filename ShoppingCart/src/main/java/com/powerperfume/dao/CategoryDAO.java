package com.powerperfume.dao;



import java.util.List;

import com.powerperfume.model.Category;

public interface CategoryDAO {


	public List<Category> list(int sortOrder);
	
	public List<Category> listFlag(boolean isMale, int sortOrder);

	public Category get(String id);
	
	public boolean save(Category category);
	
	public boolean update(Category category);

	public boolean delete(String id);


}