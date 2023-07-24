package com.springboot.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.*;
import com.springboot.repository.UserModelRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
	
	@Autowired
	private UserModelRepository customerModelRepository;
	
	public ResponseModelListPayload<UserModel> getAllCustomers() {
		return new ResponseModelListPayload<UserModel>(ResponseModel.SUCCESS, customerModelRepository.findAll());
	}
	
	
	public ResponseModelSinglePayload<UserModel> getCustomerById(String id) {
		
		Optional<UserModel> custById = customerModelRepository.findById(id);
		
		if(custById.isEmpty()) {
			return new ResponseModelSinglePayload<UserModel>(ResponseModel.FAILURE, "Customer not found by this ID", null);
		}
		
		UserModel custFound = custById.get();
		
		return new ResponseModelSinglePayload<UserModel>(ResponseModel.SUCCESS, "User Found", custFound);
	}
	
	@Transactional
	public ResponseModelSinglePayload<UserModel> updateCustomer(UserModel customerToUpdate, String id) {
		
		Optional<UserModel> customer = customerModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModelSinglePayload<UserModel>(ResponseModel.FAILURE, "Cusotmer not found", null);
		}
		
		UserModel customerCurrent = customer.get();
		customerModelRepository.save(customerToUpdate);
		return new ResponseModelSinglePayload<UserModel>(ResponseModel.SUCCESS, "Customer updated successfully", customerCurrent);
		
	}
	
	public ResponseModel deleteCustomer(String id) {
		
		Optional<UserModel> customer = customerModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModel(ResponseModel.FAILURE, "Cusotmer not found");
		}
		
		customerModelRepository.deleteById(id);
		return new ResponseModel(ResponseModel.SUCCESS, "Cusotmer deleted successfully");
	}
}
