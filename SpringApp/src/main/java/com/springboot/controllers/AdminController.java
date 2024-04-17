package com.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/getUser")
	public ResponseModelSinglePayload<UserModel> getCustomerById(@RequestParam(name = "id") String id) {
		return adminService.getUserById(id);
	}
	
	@PostMapping(path = "/updateUser")
	public ResponseModelSinglePayload<UserModel> updateUser(@RequestBody UserModel customerModel, @RequestParam(name = "id") String id) {
		return adminService.updateUser(customerModel, id);
	}
	
	@GetMapping(path = "/deleteUser")
	public ResponseModel deleteCustomer(@RequestParam(name = "id") String id) {
		return adminService.deleteUser(id);
	}
	
	
}
