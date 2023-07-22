package com.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.*;
import com.springboot.repository.CustomerModelRepository;

@Service
public class CustomerService extends CustomerModel {
	
	@Autowired
	private CustomerModelRepository customerModelRepository;
	
	public ResponseModel signupCustomer(CustomerModel customer) {
		
		Optional<CustomerModel> custbyId = customerModelRepository.findById(customer.getCustId());
		Optional<CustomerModel> custbyMobileNo = customerModelRepository.findById(customer.getMobileNo());
		
		if(!custbyId.isEmpty() || !custbyMobileNo.isEmpty()) {
			return new ResponseModel(ResponseModel.FAILURE, "Customer with this ID or Mobile No already exists.");
		}
		
		customerModelRepository.save(customer);
		
		return new ResponseModel(ResponseModel.SUCCESS, "Customer is registered successfully");
	}
	
	
	
}
