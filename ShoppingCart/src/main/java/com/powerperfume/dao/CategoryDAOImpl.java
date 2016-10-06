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
	Category category;
	
	@Autowired
	private SessionFactory sessionFactory;


	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	
	private String listHelper(int sortOrder)
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
		
		return sort;
	}
	
	@Transactional
	public List<Category> list(int sortOrder)
	{
		
		String hql = "from Category order by " + listHelper(sortOrder);		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();


		return list;
	}


	@Transactional
	public List<Category> listFlag(boolean isMale, int sortOrder)
	{
		String hql = "from Category where is_male = " + isMale + " order by " + listHelper(sortOrder);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();


		
		
			return list;
		}
	@Transactional
	public Category get(String id)
	{
		return sessionFactory.getCurrentSession().get(Category.class, id);
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
		