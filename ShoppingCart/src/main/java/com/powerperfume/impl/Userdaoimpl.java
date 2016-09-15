package com.powerperfume.impl;

public class Userdaoimpl {
	
	
	@Repository
	public class Userdaoimpl implements Userdao {
		

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
		public void delete(String id) {
			User user = new User();
			user.setId(id);
			sessionFactory.getCurrentSession().delete(user);
		}

		@Transactional
		public User get(String id) {
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
		public boolean isValidUser(String id, String password, boolean isAdmin) {
			String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return true;
			}
			
			return false;
		}


	}

}
