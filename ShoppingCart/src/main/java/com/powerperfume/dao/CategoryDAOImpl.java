package com.powerperfume.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.CategoryDAO;
import com.powerperfume.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;


	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<Category> list(int sortOrder)
	{
		String sort = "name";
		
		switch(sortOrder)
		{
			case 0:
				sort = "name";
				break;
			case 1:
				sort = "is_male";
				break;
			case 2:
				sort = "id";
				break;
			
			default:
				sort = "name";
		}
		
		String hql = "from Category order by " + sort;		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();


		return list;
	}


	@Transactional
	public Category get(String id)
	{
		String hql = "from Category where id = '" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();


		if (list != null && !list.isEmpty())
		{
			return list.get(0);
		}


		return null;
	}
	
	@Transactional
	public boolean save(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().save(category);
		}
		catch(Exception e)
		{
			System.out.println("Exception on saving category: " + e);
			return false;
		}
		
		return true;
	}


	@Transactional
	public boolean update(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating category: " + e);
			return false;
		}
		
		return true;
	}


	@Transactional
	public boolean delete(String id)
	{
		Category category = new Category();
		category.setId(id);
		
		try
		{
			sessionFactory.getCurrentSession().delete(category);
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting category: " + e);
			return false;
		}
		
		return true;
	}
}
		