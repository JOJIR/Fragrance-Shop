package com.powerperfume.dao;

import java.util.List;


import com.powerperfume.model.Supplier;

public interface SupplierDAO {


	public List<Supplier> list(int sortOrder);

	public Supplier get(int id);

	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);

	public boolean delete(int id);


}
