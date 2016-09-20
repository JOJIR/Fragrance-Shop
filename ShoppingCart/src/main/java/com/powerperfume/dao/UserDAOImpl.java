package com.powerperfume.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.powerperfume.dao.UserDAO;
import com.powerperfume.model.User;
import com.powerperfume.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	@Autowired
	private SessionFactory sessionFactory;


	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}


	@Transactional
	public void delete(Integer id) {
		User user = new User();
		UserDetails userDetails = new UserDetails();
		user.setId(id);
		userDetails.setId(id);
		sessionFactory.getCurrentSession().delete(user);
		sessionFactory.getCurrentSession().delete(userDetails);
	}

	@Transactional
	public User get(Integer id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public boolean isValidUser(String email, String password, boolean isAdmin) {
		String hql = "from User where email = '" + email + "' and password = '" + password + "' and admin = " + isAdmin;;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	
	@Transactional
	public boolean validateRegistration(UserDetails userDetails)
	{
		if(userDetails.getEmail() == null)
			return false;
		String hql = "from User where email = '" + userDetails.getEmail() + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		@SuppressWarnings("unchecked")
		List<User> list =(List<User>)query.list();
		
		if(list != null && !list.isEmpty())
			return false;
		
		return true;
	}


}
