package com.venkatesh.response;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

import com.lowagie.text.pdf.PdfPCell;

import lombok.Data;

@Data
public class SearchResponse {
	
	private Integer caseNum;
	
	private String planName;
	
	private String planStatus;
	
	private String holoderName;
	
	private Integer holderSSN;
	
	private Double benefitAmt;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String denialReasn;

	
	
	
	



}
