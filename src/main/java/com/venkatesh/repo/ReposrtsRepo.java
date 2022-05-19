package com.venkatesh.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.venkatesh.entity.Eligibility;

@Repository
public interface ReposrtsRepo extends JpaRepository<Eligibility, Serializable> {

	@Query("select distinct(planName) from Eligibility")
	public List<String> getUniquePlanName();

	@Query("select distinct(planStatus) from Eligibility")
	public List<String> getUniquePlanStatus();
	
} 
