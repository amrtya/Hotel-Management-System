package com.springboot.controllers;

import com.springboot.repository.ReservationModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/reception")
public class ReceptionController {
	
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private ReservationModelRepository reservationModelRepository;

	@GetMapping(path = "/checkStatus")
	public ResponseModelListPayload<ReservationModel> checkApprovalStatus(@RequestParam("filter_by") String filter) {
		return reservationService.pendingApproval(filter);
	}
	
	@GetMapping(path = "/approve")
	public ResponseModel approveReservation(@RequestParam("revId") String revId, @RequestParam("status") String status, @RequestParam("room-list") String[] rooms, @RequestParam("rejectionReason") String rejectionReason) {
		return reservationService.approveReservation(revId, status, rooms, rejectionReason);
	}
	
	@GetMapping(path = "/searchRoom")
	public ResponseModelListPayload<RoomModel> fetchRoomByStatus(@RequestParam("status") String status) {
		return roomService.fetchRoomByStatus(status);
	}

	@Scheduled(cron = "0 0/15 * * * *")
	public void ScheduleDeleteRejectedReservations() {
		reservationModelRepository.deleteRejectedReservation();
	}
}
