package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.CustomerModel;
import com.springboot.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	// This controller class gives the endpoints for admin. 
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/getAllCust")
	public List<CustomerModel> getAllCustomers() {
		return adminService.getAllCustomers();
	}
}
