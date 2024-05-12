package com.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.models.ReservationModel;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReservationModelRepository extends JpaRepository<ReservationModel, String> {

	@Transactional
	@Modifying
	@Query(value = "DELETE r FROM REV_DETAILS r where r.approvalStatus = 'REJECTED'", nativeQuery = true)
	void deleteRejectedReservation();
	
	@Query(value = "SELECT * FROM REV_DETAILS r WHERE r.approvalStatus = ?1", nativeQuery = true)
	Optional<List<ReservationModel>> findPendingApprovals(String filter);

	@Query(value = "SELECT * FROM REV_DETAILS r WHERE r.userid = ?1", nativeQuery = true)
	Optional<List<ReservationModel>> fetchReservationOfUser(String userId);

	@Query(value = "SELECT * FROM REV_DETAILS WHERE checkInDate = ?1 AND approvalStatus = 'APPROVED' ORDER BY checkInDate", nativeQuery = true)
	Optional<List<ReservationModel>> getCheckInsToday(String date);

	@Query(value = "SELECT * FROM REV_DETAILS WHERE checkoutDate = ?1 AND approvalStatus = 'APPROVED' ORDER BY checkoutDate", nativeQuery = true)
	Optional<List<ReservationModel>> getCheckOutsToday(String date);
}
