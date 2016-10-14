package com.powerperfume.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.CardDetails;
import com.powerperfume.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO
{
	@Autowired
	User user;

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list(int sortOrder)
	{
		String sort = "first_name";

		switch(sortOrder)
		{
		case 0:
			sort = "first_name";
			break;
		case 1:
			sort = "last_name";
			break;
		case 2:
			sort = "contact_no";
			break;
		case 3:
			sort = "email";
			break;
		case 4:
			sort = "role";
			break;
		default:
			sort = "first_name";
		}

		String hql = "from User order by " + sort;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		return list;
	}

	@Transactional
	public User get(String email)
	{
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	@Transactional
	public boolean save(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
		}catch(Exception e)
		{
			System.out.println("Exception on saving user: " + e);
			return false;
		}

		return true;
	}

	@Transactional
	public boolean update(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
		}catch(Exception e)
		{
			System.out.println("Exception on updating user: " + e);
			return false;
		}

		return true;
	}

	@Transactional
	public boolean delete(String email)
	{
		user.setEmail(email);

		try
		{
			sessionFactory.getCurrentSession().delete(user);
		}catch(Exception e)
		{
			System.out.println("Exception on deleting user: " + e);
			return false;
		}

		return true;
	}

	@Transactional
	public User getValidUser(User user)
	{
		User u = get(user.getEmail());
		if(u != null && u.getPassword().equals(user.getPassword()))
			return u;

		return null;
	}

	@Transactional
	public boolean validateRegistration(User user)
	{
		if(user.getEmail() == null || get(user.getEmail()) != null)
			return false;

		return true;
	}

	@Transactional
	public void registerUser(User user)
	{
		user.setRole("ROLE_USER");
		for(CardDetails c : user.getCardDetails())
			c.setUser(user);
		save(user);
	}
}