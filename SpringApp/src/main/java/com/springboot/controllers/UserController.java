package com.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.*;
import com.springboot.services.ReservationService;
import com.springboot.services.RoomService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	// This controller class gives the operations of various users like- Manager, Employee, Customer. 
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	/* This method is required to reserve room(s), applicable only for Customer */
	
	@PostMapping(path = "/reservation")
	public ResponseModel requestReservation(@RequestBody ReservationModel reservationModel, @RequestHeader("user-id") String userId) {
		return reservationService.requestReservation(reservationModel, userId);
	}
	
	@GetMapping(path = "/checkStatus/{filter_by}")
	public ResponseModelListPayload<ReservationModel> checkApprovalStatus(@PathVariable("filter_by") String filter) {
		return reservationService.pendingApproval(filter);
	}
	
	@GetMapping(path = "/approve")
	public ResponseModel approveReservation(@RequestHeader("revId") String revId, @RequestParam("status") String status, @RequestParam("room-list") String[] rooms) {
		return reservationService.approveReservation(revId, status, rooms);
	}
	
	@PostMapping(path = "/addRoom")
	public ResponseModelListPayload<RoomModel> addRoom(@RequestBody RoomModel room) {
		room.setIsOccupied(RoomModel.VACANT);
		return roomService.addRoom(room); 
	}
}
