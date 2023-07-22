package com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.CustomerModel;
import com.springboot.repository.CustomerModelRepository;

@Service
public class AdminService {
	
	@Autowired
	private CustomerModelRepository customerModelRepository;
	
	public List<CustomerModel> getAllCustomers() {
		return customerModelRepository.findAll();
	}
}
