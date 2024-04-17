package com.springboot.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.models.RoomModel;

public interface RoomModelRepository extends JpaRepository<RoomModel, String> {
	
	@Query(value = "SELECT COUNT(*) FROM RoomModel WHERE roomId = ?1", nativeQuery = true)
	int checkAvailableOrNot(String roomId);
	
	@Query(value = "SELECT r FROM RoomModel r WHERE r.isOccupied = ?1")
	Optional<List<RoomModel>> fetchRoomByStatus(String status);
}
