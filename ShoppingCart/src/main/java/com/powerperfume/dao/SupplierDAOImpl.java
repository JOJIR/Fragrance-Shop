package com.powerperfume.dao;


import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.powerperfume.dao.SupplierDAO;
import com.powerperfume.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	private SessionFactory sessionFactory;


	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Supplier> list(int sortOrder) {
		
		String sort = "name";
		
		switch(sortOrder)
		{
		case 0:
			sort = "name";
			break;
		case 1:
			sort = "address";
			break;
		case 2:
			sort = "id";
			break;
		default:
			sort = "name";
		}
		
		
		String hql = "from Supplier order by " + sort;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
				
		return list;
	}

	
	@Transactional
	public Supplier get(int id)
	{
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
	}
	
	@Transactional
	public boolean save(Supplier supplier) {
		
		try
		{
		sessionFactory.getCurrentSession().save(supplier);
		}
		catch(Exception e)
		{
			System.out.println("Exception on saving supplier: " + e);
			return false;
		}
		return true;
	}
	
	
	@Transactional
	public boolean update(Supplier supplier)
	{
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating supplier: " + e);
			return false;
		}
		return true;
	}
	
	
	@Transactional
	public boolean delete(int id) {
		supplier.setId(id);
		
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting supplier: " + e);
			return false;
		}
		
		return true;
		
	}

}	
