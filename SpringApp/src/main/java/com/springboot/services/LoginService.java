package com.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.AdminModel;
import com.springboot.models.LoginModel;
import com.springboot.models.ResponseModel;
import com.springboot.repository.LoginModelRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginModelRepository loginModelRepository;
	
	public ResponseModel loginUser(LoginModel user) {
		
		Optional<LoginModel> custByMob = loginModelRepository.findByMobNo(user.getMobNo());
		
		if(custByMob.isPresent()) {
			if(custByMob.get().getPassword().equals(user.getPassword())) {
				return new ResponseModel(ResponseModel.SUCCESS, "Logged in Successfully");
			}
			else 
				return new ResponseModel(ResponseModel.FAILURE, "Incorrect Password");
		}
		else 
			return new ResponseModel(ResponseModel.FAILURE, "User not found by this mobile number");
	}
	
	public ResponseModel loginAdmin(AdminModel admin) {
		if(admin.getFirstName() == "admin" && admin.getPassword() == "admin123") {
			return new ResponseModel(ResponseModel.SUCCESS, "Welcome Admin"); 
		}
		
		return new ResponseModel(ResponseModel.FAILURE, "Incorrect Admin Credential");
	}
}
