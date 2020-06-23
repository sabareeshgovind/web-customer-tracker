package com.sabareesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabareesh.dao.CustomerDAO;
import com.sabareesh.hibernate.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		//Get customers from DAO method
		List <Customer> theCustomers =  customerDAO.getCustomers();
		model.addAttribute("customers",theCustomers);
		return "list-customers";
		
	}

}
