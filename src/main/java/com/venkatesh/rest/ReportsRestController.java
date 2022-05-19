package com.venkatesh.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatesh.reports.ExcelGenerator;
import com.venkatesh.reports.PdfGenerator;
import com.venkatesh.request.SerachRequest;
import com.venkatesh.response.SearchResponse;
import com.venkatesh.service.ReportsService;

@RestController
public class ReportsRestController {

	@Autowired
	private ReportsService service;

	@GetMapping("/plannames")
	public List<String> getUniquePlanNames() {
		return service.getPlanName();

	}

	@GetMapping("/planstatus")
	public List<String> getUniquePlanStatus() {
		return service.getplanStatus();

	}

	@PostMapping("/serach")
	public List<SearchResponse> serachplan(@RequestBody SerachRequest request) {
		return service.serachplan(request);

	}

	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse httpResponse) throws Exception {

		// we need to set some configuration in the httpResponse for excel generation

		httpResponse.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.xls";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.serachplan(null);

		ExcelGenerator excel = new ExcelGenerator();

		excel.generateExcel(records, httpResponse);// calling the method in ExcelGenerator class
	}

	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse httpResponse) throws Exception {

		httpResponse.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Plans.pdf";
		httpResponse.setHeader(headerKey, headerValue);

		List<SearchResponse> records = service.serachplan(null);

		PdfGenerator pdf = new PdfGenerator();
		pdf.generatePdf(records, httpResponse);
	}
}
