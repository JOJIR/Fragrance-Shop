package com.powerperfume.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.AddressDAO;
import com.powerperfume.model.Address;

@Repository("addressDAO")
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	Address address;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AddressDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory =  sessionFactory;
	}
	
	@Transactional
	public List<Address> list(int sortOrder)
	{
		String sort = "id";
		
		switch(sortOrder)
		{
			case 0:
				sort = "street";
				break;
			case 1:
				sort = "city";
				break;
			case 2:
				sort = "pin";
				break;
			case 4:
				sort = "id";
				break;
			default:
				sort = "id";
			
				}
		String hql = "from Address order by " + sort;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
				@SuppressWarnings("unchecked")
				List<Address> list = (List<Address>) query.list();
				
				
				return list;
	}
	
	
	@Transactional
	public Address get(int id)
	{
		return sessionFactory.getCurrentSession().get(Address.class, id);
		
	}
	
	public String byEmail(String email)
	{
		
		return "from Address where email = '" + email + "'";
		
	}
	
		
	@Transactional
	public boolean save(Address address)
	{
		try
		{
			sessionFactory.getCurrentSession().save(address);
		}
		catch(Exception e)
		{
			System.out.println("Exception on saving address: " + e);
				return false;
		}
		
		return true;
	}
	
	@Transactional
	public boolean update(Address address)
	{
		try
		{
			sessionFactory.getCurrentSession().update(address);
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating address: " + e);
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public boolean delete(int id)
	{
	address.setId(id);
	
	try
	{
		sessionFactory.getCurrentSession().delete(address);
		
	}
	catch(Exception e)
	{
		System.out.println("Exception on deleting address: " + e);
		return false;
	}
	
		return true;
	}
	
	
}
