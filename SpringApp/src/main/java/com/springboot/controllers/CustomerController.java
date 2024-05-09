package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping(path = "/deleteReservation")
	public ResponseModel deleteReservation(@RequestParam("rev-id") String revId) {
		return reservationService.deleteReservation(revId);
	}

	@GetMapping(path = "/fetchReservations")
	public ResponseModelListPayload<ReservationModel> fetchReservations(@RequestParam("user-id") String userId) {
		return reservationService.fetchReservation(userId);
	}
}
