package com.venkatesh.request;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Data;

@Data
public class SerachRequest {

	
	
	private String planName;
	
	
	private String planStatus;
	
	
	private LocalDate startDate;
	
	
	private LocalDate endDate;
	
}
