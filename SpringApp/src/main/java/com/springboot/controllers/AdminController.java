package com.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	// This controller class gives the endpoints and operations for admin. 
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getUsers")
	public ResponseModelListPayload<UserModel> getAllCustomers() {
		return adminService.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseModelSinglePayload<UserModel> getCustomerById(@PathVariable String id) {
		return adminService.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateUser/{id}")
	public ResponseModelSinglePayload<UserModel> updateCustomer(@RequestBody UserModel customerModel, @PathVariable String id) {
		return adminService.updateUser(customerModel, id);
	}
	
	@GetMapping(path = "/deleteUser")
	public ResponseModel deleteCustomer(@RequestParam(name = "id") String id) {
		return adminService.deleteUser(id);
	}
	
	
}
