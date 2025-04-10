package com.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.AdminModel;
import com.springboot.models.LoginModel;
import com.springboot.models.ResponseModel;
import com.springboot.services.LoginService;

@CrossOrigin
@RestController
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping
	public ResponseModel loginUser(@RequestBody LoginModel loginModel) {
		return loginService.loginUser(loginModel);
	}
	
	@PostMapping(path = "/admin")
	public ResponseModel loginAdmin(@RequestBody AdminModel adminModel) {
		return loginService.loginAdmin(adminModel);
	}
	
}
