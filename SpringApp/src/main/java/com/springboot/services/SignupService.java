package com.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.*;
import com.springboot.repository.UserModelRepository;
import com.springboot.repository.LoginModelRepository;

@Service
public class SignupService {
	
	@Autowired
	private UserModelRepository customerModelRepository;
	
	@Autowired
	private LoginModelRepository loginModelRepository;
	
	public ResponseModel signupUser(UserReceiver newUser) {
		
		Optional<UserModel> custbyMobileNo = customerModelRepository.findCustomerByMob(newUser.getMobileNo());
		
		if(custbyMobileNo.isPresent()) {
			return new ResponseModel(ResponseModel.FAILURE, "Customer with this Mobile No already exists.");
		}
		
		UserModel customer = newUser.getCustomerModel();
		
		customerModelRepository.save(customer);
		
		loginModelRepository.save(new LoginModel(newUser.getMobileNo(), newUser.getPwd(), newUser.getJobRole()));
		
		return new ResponseModel(ResponseModel.SUCCESS, "Customer is registered successfully");
	}
	
}
