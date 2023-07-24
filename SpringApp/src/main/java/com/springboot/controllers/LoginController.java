package com.springboot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.models.LoginModel;
import com.springboot.models.ResponseModel;
import com.springboot.services.LoginService;

@Controller
@RequestMapping(path = "/login")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping
	public ResponseModel loginUser(@RequestBody LoginModel loginModel) {
		return loginService.loginUser(loginModel);
	}
	
}
