package com.powerperfume.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Supplierdaoimpl implements Supplierdao {

		

		@Autowired
		private SessionFactory sessionFactory;


		public Supplierdaoimpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public List<Supplier> list() {
			@SuppressWarnings("unchecked")
			List<Supplier> list = (List<Supplier>) sessionFactory.getCurrentSession()
					.createCriteria(Supplier.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return list;
		}

		@Transactional
		public void saveOrUpdate(Supplier supplier) {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		}

		@Transactional
		public void delete(String id) {
			Supplier supplier = new Supplier();
			supplier.setId(id);
			sessionFactory.getCurrentSession().delete(supplier);
		}

		@Transactional
		public Supplier get(String id) {
			String hql = "from Supplier where id=" + id;
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Supplier> list = (List<Supplier>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
		}


	}

}
