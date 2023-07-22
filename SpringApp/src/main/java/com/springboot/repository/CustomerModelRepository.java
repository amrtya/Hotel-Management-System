package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.models.CustomerModel;

@Repository
public interface CustomerModelRepository extends JpaRepository<CustomerModel, String> {
	
}
