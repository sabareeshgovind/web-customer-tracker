package com.sabareesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sabareesh.dao.CustomerDAO;
import com.sabareesh.hibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers(); //delegate method from DAO layer.
	}


	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
		
	}


	@Transactional
	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}


	@Transactional
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
		
	}
	
	

}
