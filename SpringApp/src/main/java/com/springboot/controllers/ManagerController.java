package com.springboot.controllers;

import com.springboot.dto.AddRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.models.ReservationModel;
import com.springboot.models.ResponseModel;
import com.springboot.models.ResponseModelListPayload;
import com.springboot.models.RoomModel;
import com.springboot.services.ReservationService;
import com.springboot.services.RoomService;

@CrossOrigin
@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping(path = "/addRoom")
	public ResponseModelListPayload<RoomModel> addRoom(@RequestBody AddRoomDTO room) {
		return roomService.addRoom(room); 
	}
	
	@GetMapping(path = "/fetchRoomDetails")
	public ResponseModelListPayload<RoomModel> fetchRooms() {
		return roomService.fetchRooms();
	}
}
