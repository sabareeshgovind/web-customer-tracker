package com.sabareesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabareesh.dao.CustomerDAO;
import com.sabareesh.hibernate.entity.Customer;
import com.sabareesh.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer DAO
	/*
	@Autowired
	private CustomerDAO customerDAO;
	*/
	
	//inject service layer
	@Autowired
	private CustomerService service;
	
	
	
	//@RequestMapping("/list")
	//can use above but for in this case we use get mapping
	//also post mapping will throw error because we are getting data from a resource
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//Get customers from DAO method
		try {
			List <Customer> theCustomers =  service.getCustomers();
			model.addAttribute("customers", theCustomers);
		} catch (Exception e) {
			System.out.println(e);
		}
//		List <Customer> theCustomers =  customerDAO.getCustomers();
//		model.addAttribute("customers", theCustomers);
		return "list-customers";
		
	}
	
	

}
