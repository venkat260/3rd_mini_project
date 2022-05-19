package com.venkatesh.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.venkatesh.entity.Eligibility;
import com.venkatesh.repo.ReposrtsRepo;
import com.venkatesh.request.SerachRequest;
import com.venkatesh.response.SearchResponse;

@Service
public class ReportServiceImpl implements ReportsService {

	@Autowired
	private ReposrtsRepo repo;

	@Override
	public List<String> getPlanName() {
		List<String> name = repo.getUniquePlanName();
		return name;
	}

	@Override
	public List<String> getplanStatus() {
		List<String> status = repo.getUniquePlanStatus();
		return status;
	}

	@Override
	public List<SearchResponse> serachplan(SerachRequest request) {
		List<Eligibility> eligRecords = null;
		if (request==null) {
			eligRecords = repo.findAll();// it is list of eligibility list we need to convert into
											// searchResponse
											// so that ui accept only searchResponse
		} else {
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();

			Eligibility entity = new Eligibility();

			if (planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			if (planStatus != null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}
			if (startDate != null && startDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}
			Example<Eligibility> of = Example.of(entity);

			eligRecords = repo.findAll(of);// we are or ui is expecting SearchResponse entity
		}
			List<SearchResponse> responses=new ArrayList<>();
			
			for (Eligibility  records: eligRecords)
			{
				SearchResponse sr=new SearchResponse();
				
				BeanUtils.copyProperties(records, sr);
				
				responses.add(sr);
			}
		

		return responses;
	}

	/*private boolean isSearchRequestEmpty(SerachRequest request) {

		
		if (request.getPlanName() != null && !request.getPlanName().equals("")) {
			return false;
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			return false;
		}
		if (request.getStartDate() != null && !request.getStartDate().equals("")) {
			return false;
		}
		if (request.getEndDate() != null && !request.getEndDate().equals("")) {
			return false;
		}
		return true;
	}*/
	

}
