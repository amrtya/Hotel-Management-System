package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.models.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, String> {
	
	@Query("SELECT c from UserModel c WHERE c.mobileNo = ?1")
	Optional<UserModel> findCustomerByMob(String mobNo);
}
