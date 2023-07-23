package com.springboot.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.*;
import com.springboot.repository.CustomerModelRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
	
	@Autowired
	private CustomerModelRepository customerModelRepository;
	
	public ResponseModelListPayload<CustomerModel> getAllCustomers() {
		return new ResponseModelListPayload<CustomerModel>(ResponseModel.SUCCESS, customerModelRepository.findAll());
	}
	
	
	public ResponseModelSinglePayload<CustomerModel> getCustomerById(String id) {
		
		Optional<CustomerModel> custById = customerModelRepository.findById(id);
		
		if(custById.isEmpty()) {
			return new ResponseModelSinglePayload<CustomerModel>(ResponseModel.FAILURE, "Customer not found by this ID", null);
		}
		
		CustomerModel custFound = custById.get();
		
		return new ResponseModelSinglePayload<CustomerModel>(ResponseModel.SUCCESS, "User Found", custFound);
	}
	
	@Transactional
	public ResponseModelSinglePayload<CustomerModel> updateCustomer(CustomerModel customerToUpdate, String id) {
		
		Optional<CustomerModel> customer = customerModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModelSinglePayload<CustomerModel>(ResponseModel.FAILURE, "Cusotmer not found", null);
		}
		
		CustomerModel customerCurrent = customer.get();
		customerModelRepository.save(customerToUpdate);
		return new ResponseModelSinglePayload<CustomerModel>(ResponseModel.SUCCESS, "Customer updated successfully", customerCurrent);
		
	}
	
	public ResponseModel deleteCustomer(String id) {
		
		Optional<CustomerModel> customer = customerModelRepository.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseModel(ResponseModel.FAILURE, "Cusotmer not found");
		}
		
		customerModelRepository.deleteById(id);
		return new ResponseModel(ResponseModel.SUCCESS, "Cusotmer deleted successfully");
	}
}
