package com.powerperfume.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.powerperfume.dao.CardDetailsDAO;
import com.powerperfume.model.CardDetails;

@Repository("cardDetailsDAO")
public class CardDetailsDAOImpl implements CardDetailsDAO{
	
	@Autowired
	CardDetails cardDetails;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CardDetailsDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory = sessionFactory;
	}
	

	public List<CardDetails> list(int sortOrder) {
		
		String sort = "email";
		
		switch(sortOrder)
		{
		case 0:
			sort = "email";
			break;
		case 1:
			sort = "cardNumber";
			break;
		case 2:
			sort = "cvv";
			break;
		case 3:
			sort = "expiryMonth";
			break;
		case 4:
			sort = "expiryYear";
			break;
		case 5:
			sort = "name";
			break;
		case 6:
			sort = "id";
			break;
			default:
				sort = "email";
		}
		
		String hql = "from CardDetails order by " + sort;
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<CardDetails> list = (List<CardDetails>) query.list();
		return list;
	}

	@Transactional
	public CardDetails get(int id) {
		
		return sessionFactory.getCurrentSession().get(CardDetails.class, id);
	}

	@Transactional
	public boolean save(CardDetails cardDetails) {
		
			try
			{
				sessionFactory.getCurrentSession().save(cardDetails);
			}
			catch(Exception e)
			{
				System.out.println("Exception on saving card details: " +e);
				return false;
			}
		
				return true;
		}

	@Transactional
	public boolean update(CardDetails cardDetails) {
		
		try
		{
			sessionFactory.getCurrentSession().update(cardDetails);
		}
		catch(Exception e)
		{
			System.out.println("Exception on updating card details: " +e);
			return false;
		}
			return true;
	}
	
	
	@Transactional
	public boolean delete(int id) {
		
		cardDetails.setId(id);
		
		try
		{
			sessionFactory.getCurrentSession().delete(cardDetails);
		}
		catch(Exception e)
		{
			System.out.println("Exception on deleting card details:" + e);
			return false;
		}
		
		return true;
	}
	

}
