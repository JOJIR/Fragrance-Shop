package com.powerperfume.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.OrderDAO;
import com.powerperfume.model.Order;

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	Order order;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Order> list() {
		
		String hql = "from Order";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>) query.list();
		
		
		return list;
	}
	
	@Transactional
	public Order get(int id) {
	
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Transactional
	public boolean save(Order order) {
		
		try
		{
			sessionFactory.getCurrentSession().save(order);
		}
		catch(Exception e)
		{
			System.out.println("Exception on saving order: " + e);
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(Order order) {
		
		try
		{
		
			sessionFactory.getCurrentSession().update(order);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating order: " + e);
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(int id) {
		
		
		try
		{
			sessionFactory.getCurrentSession().delete(get(id));
			
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting order: " + e);
		
		return false;
		}
	
	return true;
	
	}

}
