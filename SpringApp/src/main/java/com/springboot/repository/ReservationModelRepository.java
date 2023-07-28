package com.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.models.ReservationModel;

@Repository
public interface ReservationModelRepository extends JpaRepository<ReservationModel, String> {
	
	@Query("SELECT COUNT(*) FROM ReservationModel")
	int noOfEntries();
	
	@Query(value = "SELECT COUNT(*) FROM ReservationModel r where r.userid = ?1", nativeQuery = true)
	int checkAlreadyReserved(String userId);
	
	@Query(value = "SELECT * FROM ReservationModel r WHERE r.approvalStatus = ?1", nativeQuery = true)
	Optional<List<ReservationModel>> findPending(String filter);
}
