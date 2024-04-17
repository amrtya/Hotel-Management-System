package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.models.ResponseModel;
import com.springboot.models.ResponseModelListPayload;
import com.springboot.models.RoomModel;
import com.springboot.repository.RoomModelRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomModelRepository roomModelRepository;
	
	public ResponseModelListPayload<RoomModel> addRoom(RoomModel room) {
		roomModelRepository.save(room);
		
		return new ResponseModelListPayload<RoomModel>(ResponseModel.SUCCESS, "Room added successfully", roomModelRepository.findAll());
	}
	
	public ResponseModelListPayload<RoomModel> fetchRooms() {
		return new ResponseModelListPayload<RoomModel>(ResponseModel.SUCCESS, roomModelRepository.findAll());
	}
	
	public ResponseModelListPayload<RoomModel> fetchRoomByStatus(String status) {
		Optional<List<RoomModel>> getRoomByStatus = roomModelRepository.fetchRoomByStatus(status);
		
		if(getRoomByStatus.isEmpty()) {
			return new ResponseModelListPayload<RoomModel>(ResponseModel.FAILURE, "No room present by " + status +" status", null);
		}
		
		List<RoomModel> roomFound = getRoomByStatus.get();
		
		return new ResponseModelListPayload<RoomModel>(ResponseModel.SUCCESS, "", roomFound);
	}
}
