package com.venkatesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ELIGIBILITY_DTLS")
@Data
public class Eligibility {
	
	/*PLAN_ID (PK)
CASE_NUM
PLAN_NAME
PLAN_STATUS
HOLDER_NAME
HOLDER_SSN
BENEFIT_AMT
START_DATE
END_DATE
DENIAL_REASN*/
	
	@Id
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="CASE_NUM")
	private Integer caseNum;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="HOLDER_NAME")
	private String holoderName;
	
	@Column(name="HOLDER_SSN")
	private Integer holderSSN;
	
	
	@Column(name="BENEFIT_AMT")
	private Double benefitAmt;
	
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Column(name="DENIAL_REASN")
	private String denialReasn;
	
	


}
