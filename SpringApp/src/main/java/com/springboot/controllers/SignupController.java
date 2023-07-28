package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.ResponseModel;
import com.springboot.models.UserReceiver;
import com.springboot.services.SignupService;

@RestController
@RequestMapping(path = "/signup")
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	@PostMapping
	public ResponseModel signupUser(@RequestBody UserReceiver newUser) {
		return signupService.signupUser(newUser);
	}
}
