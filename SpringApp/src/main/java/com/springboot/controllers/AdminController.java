package com.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	// This controller class gives the endpoints and operations for admin. 
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getCustomers")
	public ResponseModelListPayload<UserModel> getAllCustomers() {
		return adminService.getAllCustomers();
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseModelSinglePayload<UserModel> getCustomerById(@PathVariable String id) {
		return adminService.getCustomerById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseModelSinglePayload<UserModel> updateCustomer(UserModel customerModel, @PathVariable String id) {
		return adminService.updateCustomer(customerModel, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCustomer/{id}")
	public ResponseModel deleteCustomer(@PathVariable String id) {
		return adminService.deleteCustomer(id);
	}
	
	
}
