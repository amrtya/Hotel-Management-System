package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.models.ResponseModel;
import com.springboot.models.UserReceiver;
import com.springboot.services.SignupService;

@Controller
@RequestMapping(path = "/signup")
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	public ResponseModel signupUser(UserReceiver newUser) {
		return signupService.signupUser(newUser);
	}
}
