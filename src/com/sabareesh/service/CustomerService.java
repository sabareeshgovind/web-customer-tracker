package com.sabareesh.service;

import java.util.List;

import com.sabareesh.hibernate.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
