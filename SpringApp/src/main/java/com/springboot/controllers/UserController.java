package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.repository.ReservationModelRepository;
import com.springboot.services.ReservationService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// This controller class gives the endpoints for customers. 
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationModelRepository reservationModelRepository;
	
	@PostMapping(path = "/reservation")
	public ResponseModel requestReservation(@RequestBody ReservationModel reservationModel, @RequestHeader("user-id") String userId) {
		return reservationService.requestReservation(reservationModel, userId);
	}
	
	@GetMapping(path = "/checkStatus/{filter_by}")
	public ResponseModelListPayload<ReservationModel> checkApprovalStatus(@PathVariable("filter_by") String filter) {
		return reservationService.pendingApproval(filter);
	}
}
