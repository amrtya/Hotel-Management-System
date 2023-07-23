package com.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.*;
import com.springboot.repository.CustomerModelRepository;
import com.springboot.repository.LoginModelRepository;

@Service
public class SignupService extends CustomerReceiver {
	
	@Autowired
	private CustomerModelRepository customerModelRepository;
	
	@Autowired
	private LoginModelRepository loginModelRepository;
	
	public ResponseModel signupCustomer(CustomerReceiver newCustomer) {
		
		Optional<CustomerModel> custbyMobileNo = customerModelRepository.findCustomerByMob(newCustomer.getMobileNo());
		
		if(custbyMobileNo.isPresent()) {
			return new ResponseModel(ResponseModel.FAILURE, "Customer with this Mobile No already exists.");
		}
		
		CustomerModel customer = newCustomer.getCustomerModel();
		
		customerModelRepository.save(customer);
		
		loginModelRepository.save(new LoginModel(newCustomer.getMobileNo(), newCustomer.getPwd()));
		
		return new ResponseModel(ResponseModel.SUCCESS, "Customer is registered successfully");
	}
	
}
