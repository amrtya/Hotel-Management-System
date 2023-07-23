package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.models.CustomerModel;

@Repository
public interface CustomerModelRepository extends JpaRepository<CustomerModel, String> {
	
	@Query("SELECT c from CustomerModel c WHERE c.mobileNo = ?1")
	Optional<CustomerModel> findCustomerByMob(String mobNo);
}
