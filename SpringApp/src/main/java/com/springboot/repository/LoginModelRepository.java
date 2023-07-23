package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.models.LoginModel;

@Repository
public interface LoginModelRepository extends JpaRepository<LoginModel, String> {
	
	@Query("SELECT c from LoginModel c WHERE c.mobNo = ?1")
	Optional<LoginModel> findByMobNo(String mobNo);
}
