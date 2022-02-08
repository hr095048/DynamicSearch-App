package in.ashokit.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.request.SearchRequest;
import in.ashokit.bindings.responce.PlanResponce;
import in.ashokit.reports.ExcelExport;
import in.ashokit.reports.PdfExport;
import in.ashokit.service.InsuranceService;

@RestController
public class InsuranceController {
	
	@Autowired
	private InsuranceService service;
	
	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponce>> search(@RequestBody SearchRequest request){
		List<PlanResponce> plan = service.search(request);
		
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		 response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<PlanResponce> list = service.search(null);
	         
	      
		ExcelExport report = new ExcelExport();
		report.excelReport(list, response);
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		 response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<PlanResponce> pdflist = service.search(null);
	         
	      
		PdfExport report = new PdfExport();
		report.pdfReport(pdflist, response);
	}
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> planNames(){
		List<String> plans = service.planNames();
		return new ResponseEntity<>(plans , HttpStatus.OK);
	}
	
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> planStatus(){
		List<String> status = service.planStatus();
		return new ResponseEntity<>(status , HttpStatus.OK);
	}

}
