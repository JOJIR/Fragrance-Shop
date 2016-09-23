package com.powerperfume.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.model.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Address> list(int sortOrder)
	{
		String sort = "email";
		
		switch(sortOrder)
		{
			case 0:
				sort = "email";
				break;
			case 1:
				sort = "street";
				break;
			case 2:
				sort = "city";
				break;
			case 3:
				sort = "is_shipping";
				break;
			case 4:
				sort = "id";
				break;
			default:
				sort = "email";
			
				}
		String hql = "from Address order by " + sort;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
				@SuppressWarnings("unchecked")
				List<Address> list = (List<Address>)
		query.list();
				
				
				return list;
	}
	
	
	@Transactional
	public Address get(int id)
	{
		
		String hql = "from Address where id = " + id;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
				@SuppressWarnings("unchecked")
				List<Address> list = (List<Address>)
		query.list();
				
				
				if (list != null && !list.isEmpty())
				{
					return list.get(0);
				}
				
				return null;
	}
	
	public String byEmail(String email)
	{
		
		return "from Address where email = '" + email + "'";
		
	}
	
	@Transactional
	public List<Address> getAll(String hql)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Address> list = (List<Address>)
query.list();
		
		return list;
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
	Address address = new Address();
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
	
	public boolean deleteAll(String hql)
	{
		List<Address> addressList = getAll(hql);
		
		try
		{
			for(Address address: addressList)
				
				sessionFactory.getCurrentSession().delete(address);
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting all address by hql: " + hql + "Exception :" +e);
			return false;
		}
			return true;
	}
	

}
