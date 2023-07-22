package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	// This controller class gives the endpoints for customers. 
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/signUp")
	public ResponseModel signupCustomer(CustomerModel customer) {
		return customerService.signupCustomer(customer);
	}
	
}
