package com.powerperfume.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.ProductDAO;
import com.powerperfume.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public String listHelper(int sortOrder) {
		
		String sort = "name";
		
		switch(sortOrder)
		{
		case 0:
			sort = "name";
			break;
		case 1:
			sort = "price";
			break;
		case 2:
			sort = "quantity";
			break;
		case 3:
			sort = "category_id";
			break;
		case 4:
			sort = "supplier_id";
		case 5:
			sort = "id";
			break;
		default:
				sort = "name";
		}
		
		return sort;
	}
	
		@Transactional
		public List<Product> list(int sortOrder)
		{
		
		String hql = "from Product order by " + listHelper(sortOrder);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();


		return list;
	}

	@Transactional
	public List<Product> listByCategory(int categoryID, int sortOrder)
	{
		String hql = "from Product where categoryID = '" + "' oreder by " + listHelper(sortOrder);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();
		
		
		return list;
	}
		
		
		
		
	@Transactional
	public Product get(String id)
	{
		String hql = "from Product where id = '" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) query.list();
		
		if(list !=null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}
	
	
	@Transactional
	public boolean save(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().save(product);
		}
		catch(Exception e)
		{
			System.out.println("Exception on saving product: " + e);
			return false;
		}
		
		return true;
	}
	
	
	@Transactional
	public boolean update (Product product){
		
		try
		{
			sessionFactory.getCurrentSession().update(product);
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating product: " + e);
			return false;
		}
		return true;
	}
	
	
	@Transactional
	public boolean delete(String id) {
		Product product = new Product();
		product.setId(id);
		
		try
		{
			sessionFactory.getCurrentSession().delete(product);
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting product: " + e);
			return false;
		}
		return true;
		
		
	}

}
