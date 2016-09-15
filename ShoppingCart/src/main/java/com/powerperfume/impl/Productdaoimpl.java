package com.powerperfume.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.powerperfume.dao.Productdao;

@Repository

public class Productdaoimpl implements Productdao {
	

	@Autowired
	private SessionFactory sessionFactory;


	public ProductDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}

	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	@Transactional
	public void delete(String id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id='" + id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}


}

