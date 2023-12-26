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
	private UserModelRepository userModelRepository;
	
	public ResponseModelListPayload<UserModel> getAllUsers() {
		return new ResponseModelListPayload<UserModel>(ResponseModel.SUCCESS, userModelRepository.findAll());
	}
	
	
	public ResponseModelSinglePayload<UserModel> getUserById(String userId) {
		
		Optional<UserModel> custById = userModelRepository.findById(userId);
		
		
		if(custById.isEmpty()) {
			return new ResponseModelSinglePayload<UserModel>(ResponseModel.FAILURE, "Customer not found by this ID", null);
		}
		
		UserModel custFound = custById.get();
		
		return new ResponseModelSinglePayload<UserModel>(ResponseModel.SUCCESS, "User Found", custFound);
	}
	
	@Transactional
	public ResponseModelSinglePayload<UserModel> updateUser(UserModel customerToUpdate, String id) {
		
		Optional<UserModel> customer = userModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModelSinglePayload<UserModel>(ResponseModel.FAILURE, "Customer not found", null);
		}
		
		UserModel customerCurrent = customer.get();
		
		if(customerToUpdate.getPassword()!=null && !customerCurrent.getPassword().equals(customerToUpdate.getPassword())) {
			return new ResponseModelSinglePayload<UserModel>(ResponseModel.FAILURE, "Admin is not allowed to change user password", null);
		}
		
		customerCurrent.setFirstName(customerToUpdate.getFirstName());
		customerCurrent.setLastName(customerToUpdate.getLastName());
		customerCurrent.setEmailId(customerToUpdate.getEmailId());
		customerCurrent.setJobRole(customerToUpdate.getJobRole());
		customerCurrent.setMobileNo(customerToUpdate.getMobileNo());
		
		userModelRepository.save(customerCurrent);
		return new ResponseModelSinglePayload<UserModel>(ResponseModel.SUCCESS, "Customer updated successfully", customerCurrent);
		
	}
	
	public ResponseModel deleteUser(String id) {
		
		Optional<UserModel> customer = userModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModel(ResponseModel.FAILURE, "Customer not found");
		}
		
		userModelRepository.deleteById(id);
		return new ResponseModel(ResponseModel.SUCCESS, "Customer deleted successfully");
	}
}
