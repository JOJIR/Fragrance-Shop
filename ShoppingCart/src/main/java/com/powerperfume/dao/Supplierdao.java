package com.powerperfume.dao;

import java.util.List;
import java.util.function.Supplier;

public interface Supplierdao {



	public List<Supplier> list();

	public Supplier get(String id);

	public void saveOrUpdate(Supplier supplier);

	public void delete(String id);




}
