package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.SignupService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	// This controller class gives the endpoints for customers. 
	
	@Autowired
	private SignupService signupService;
	
	@PostMapping("/signup")
	public ResponseModel signupCustomer(@RequestBody CustomerReceiver customer) {
		return signupService.signupCustomer(customer);
	}

}
