package com.springboot.services;

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
		
		return new ResponseModelListPayload<RoomModel>(ResponseModel.SUCCESS, "", roomModelRepository.findAll());
	}
}
