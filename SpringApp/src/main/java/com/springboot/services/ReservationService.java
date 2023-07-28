package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.ReservationModel;
import com.springboot.models.ResponseModel;
import com.springboot.models.ResponseModelListPayload;
import com.springboot.models.UserModel;
import com.springboot.repository.ReservationModelRepository;
import com.springboot.repository.UserModelRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationModelRepository reservationModelRepository; 
	
	@Autowired
	private UserModelRepository userModelRepository;
	 
	public ResponseModel requestReservation(ReservationModel reservationModel, String userId) {
		
		Optional<UserModel> userById = userModelRepository.findById(userId);
		
		if(reservationModelRepository.noOfEntries() > 0) {
			int alreadyReserved = reservationModelRepository.checkAlreadyReserved(userId);
		
			if(alreadyReserved > 0) {
				return new ResponseModel(ResponseModel.FAILURE, "User already reserved or submitted request for reservation");
			}
		}
		
		reservationModel.setUsers(userById.get());
		reservationModel.setApprovalStatus(ReservationModel.PENDING);
		reservationModelRepository.save(reservationModel);
		
		return new ResponseModel(ResponseModel.SUCCESS, "Reservsation Request successfully submitted");
	}
	
	public ResponseModelListPayload<ReservationModel> pendingApproval(String filter) {
		Optional<List<ReservationModel>> pendingList = reservationModelRepository.findPending(filter);
		
		if(pendingList.get().size() > 0) {
			return new ResponseModelListPayload<ReservationModel>(ResponseModel.SUCCESS, pendingList.get());
		}
		
		return new ResponseModelListPayload<ReservationModel>(ResponseModel.FAILURE, "Nothing to be reviewd here", null);
	}
}
