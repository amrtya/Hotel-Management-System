package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.ReservationService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class CustomerController {
	
	// This controller class gives the operations of various users like- Manager, Employee, Customer. 
	
	@Autowired
	private ReservationService reservationService;
	
	/* This method is required to reserve room(s), applicable only for Customer */
	
	@PostMapping(path = "/reservation")
	public ResponseModel requestReservation(@RequestBody ReservationModel reservationModel, @RequestHeader("user-id") String userId) {
		return reservationService.requestReservation(reservationModel, userId);
	}
}
