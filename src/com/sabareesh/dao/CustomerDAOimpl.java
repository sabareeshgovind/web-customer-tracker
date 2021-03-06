package com.sabareesh.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sabareesh.hibernate.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//@Transactional - moved to service layer
	public List<Customer> getCustomers() {
		
		//get a session 
		Session session = sessionFactory.getCurrentSession();
		
		//create a query 
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		//get result set 
		List<Customer> customers = theQuery.getResultList();
		
		//return results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		//get a session 
		Session session = sessionFactory.getCurrentSession();
		
		//save object 
		session.saveOrUpdate(customer);//Does update based on id.
	}

	@Override
	public Customer getCustomer(int id) {
		
		//get a session 
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer= session.get(Customer.class,id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		/* One way to do it
		Customer customer= session.get(Customer.class,id);
		session.delete(customer);
		*/
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
		
	}

}
