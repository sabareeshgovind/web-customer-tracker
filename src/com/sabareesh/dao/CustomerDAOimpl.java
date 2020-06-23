package com.sabareesh.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabareesh.hibernate.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get a session 
		Session session = sessionFactory.getCurrentSession();
		
		//create a query 
		Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
		
		//get result set 
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
	}

}