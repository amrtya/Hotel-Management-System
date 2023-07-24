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
	
	public ResponseModel signupCustomer(UserReceiver newCustomer) {
		
		Optional<UserModel> custbyMobileNo = customerModelRepository.findCustomerByMob(newCustomer.getMobileNo());
		
		if(custbyMobileNo.isPresent()) {
			return new ResponseModel(ResponseModel.FAILURE, "Customer with this Mobile No already exists.");
		}
		
		UserModel customer = newCustomer.getCustomerModel();
		
		customerModelRepository.save(customer);
		
		loginModelRepository.save(new LoginModel(newCustomer.getMobileNo(), newCustomer.getPwd(), newCustomer.getJobRole()));
		
		return new ResponseModel(ResponseModel.SUCCESS, "Customer is registered successfully");
	}
	
}
