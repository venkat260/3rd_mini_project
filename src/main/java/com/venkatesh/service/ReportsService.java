package com.venkatesh.service;

import java.util.List;


import com.venkatesh.request.SerachRequest;
import com.venkatesh.response.SearchResponse;

public interface ReportsService {

	public List<String> getPlanName();

	public List<String> getplanStatus();


	
	public List<SearchResponse> serachplan(SerachRequest request);

}
