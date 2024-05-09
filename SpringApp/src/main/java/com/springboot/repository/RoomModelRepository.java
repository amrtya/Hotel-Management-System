package com.springboot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.models.RoomModel;

public interface RoomModelRepository extends JpaRepository<RoomModel, String> {
	
	@Query(value = "SELECT COUNT(*) FROM ROOM_DETAILS WHERE roomId = ?1", nativeQuery = true)
	int checkAvailableOrNot(String roomId);
	
	@Query(value = "SELECT r FROM ROOM_DETAILS r WHERE r.status = ?1", nativeQuery = true)
	Optional<List<RoomModel>> fetchRoomByStatus(String status);
}
