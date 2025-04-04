package com.springboot.services;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.springboot.exceptions.GenericExceptions;
import com.springboot.exceptions.GlobalExceptionHandler;
import com.springboot.utils.GenericUtils;
import com.springboot.utils.RoomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springboot.models.ReservationModel;
import com.springboot.models.ResponseModel;
import com.springboot.models.ResponseModelListPayload;
import com.springboot.models.RoomModel;
import com.springboot.models.UserModel;
import com.springboot.repository.ReservationModelRepository;
import com.springboot.repository.RoomModelRepository;
import com.springboot.repository.UserModelRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationModelRepository reservationModelRepository; 
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	private RoomModelRepository roomModelRepository;

	public HashMap<String, Integer> roomWiseRevRecord = new HashMap<>();
	 
	public ResponseModel requestReservation(ReservationModel reservationModel, String userId) {
		
		Optional<UserModel> userById = userModelRepository.findById(userId);

		if(userById.isEmpty()) {
			throw new GenericExceptions("No User by this user-id");
		}
		
		reservationModel.setNoOfDays(new GenericUtils().durationBetweenDates(reservationModel.getCheckInDate(), reservationModel.getCheckoutDate()));
		reservationModel.setUsers(userById.get());
		reservationModel.setApprovalStatus(ReservationModel.PENDING);
		reservationModelRepository.save(reservationModel);
		
		return new ResponseModel(ResponseModel.SUCCESS, "Reservation Request successfully submitted");
	}
	
	
	public ResponseModelListPayload<ReservationModel> pendingApproval(String filter) {
		Optional<List<ReservationModel>> pendingList = reservationModelRepository.findPendingApprovals(filter);
		
		if(pendingList.isEmpty()) {
			throw new GenericExceptions("Nothing to be reviewed here");
		}

		return new ResponseModelListPayload<ReservationModel>(ResponseModel.SUCCESS, pendingList.get());
	}

	@Transactional
	public ResponseModel approveReservation(String revId, String status, String[] roomList, String rejectionReason) {
		if(roomList.length == 0)
			throw new GenericExceptions("Sorry!! No rooms are available now");

		Optional<ReservationModel> revById = reservationModelRepository.findById(revId);
		if(revById.isEmpty())
			throw new GenericExceptions("No reservation present with reference Id");

		ReservationModel revToUpdate = revById.get();

		if(status.equals(ReservationModel.APPROVED)) {
			revToUpdate.setApprovalStatus(ReservationModel.APPROVED);
			
			Double amount = 0.00;
			String finalroomList = "";
			
			for(String room : roomList) {
				if(roomModelRepository.findById(room).isEmpty()) {
					throw new GenericExceptions("No room found with mentioned room-id: " + room);
				}

				RoomModel roomModel = roomModelRepository.findById(room).get();
				roomWiseRevRecord.put(revId, roomModel.getRoomId());
				finalroomList += room + ",";
				amount += roomModel.getPrice();
			}

			revToUpdate.setRoomLists(finalroomList.substring(0, finalroomList.length() - 1));
			revToUpdate.setReceiptGenerated(false);
			reservationModelRepository.save(revToUpdate);
			
			return new ResponseModel(ResponseModel.SUCCESS, "Request is approved now, Total Payment = Rs." + amount);
		}

		revToUpdate.setApprovalStatus(ReservationModel.REJECTED);
		reservationModelRepository.save(revToUpdate);
		throw new GenericExceptions(rejectionReason.isBlank() ? "Request is rejected" : rejectionReason);
	}

	public ResponseModel deleteReservation(String revId) {
		Optional<ReservationModel> revById = reservationModelRepository.findById(revId);
		if(revById.isEmpty())
			throw new GenericExceptions("Invalid Reservation ID");

		reservationModelRepository.deleteById(revId);
		return new ResponseModel(ResponseModel.SUCCESS, "Reservation deleted successfully");
	}

	public ResponseModelListPayload<ReservationModel> fetchReservation(String userId) {
		Optional<List<ReservationModel>> reservationList = reservationModelRepository.fetchReservationOfUser(userId);

		if(reservationList.isEmpty()) {
			throw new GenericExceptions("No reservation present");
		}

		return new ResponseModelListPayload<>(ResponseModel.SUCCESS, "", reservationList.get());
	}

	@Scheduled(cron = "0 0/2 * * * *")
	public void ScheduleAutoRoomAllocation() {
		Optional<List<ReservationModel>> checkInsToday = reservationModelRepository.getCheckInsToday(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

		if(checkInsToday.isPresent()) {
			List<ReservationModel> revObjects = checkInsToday.get();

			for(ReservationModel rev: revObjects) {
				String[] arr = rev.getRoomLists().split(",");
				for(String roomNo: arr) {
					RoomModel room = roomModelRepository.findById(roomNo).get();
					room.setIsOccupied(RoomModel.OCCUPIED);
					room.setReservations(rev);
					roomModelRepository.save(room);
				}
			}
		}
	}

	@Scheduled(cron = "0 0/2 * * * *")
	public void ScheduleAutoRoomDeAllocation() {
		Optional<List<ReservationModel>> checkOutsToday = reservationModelRepository.getCheckOutsToday(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

		if(checkOutsToday.isPresent()) {
			List<ReservationModel> revObjects = checkOutsToday.get();

			for(ReservationModel rev: revObjects) {
				String[] arr = rev.getRoomLists().split(",");
				for(String roomNo: arr) {
					RoomModel room = roomModelRepository.findById(roomNo).get();
					room.setIsOccupied(RoomModel.VACANT);
					room.setReservations(null);
					roomModelRepository.save(room);
					reservationModelRepository.deleteById(rev.getRevId());
				}
			}
		}
	}
}
