package com.sabareesh.dao;

import java.util.List;

import com.sabareesh.hibernate.entity.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

}
