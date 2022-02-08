package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.request.SearchRequest;
import in.ashokit.bindings.responce.PlanResponce;

public interface InsuranceService {
	
	public List<PlanResponce> search(SearchRequest request);
	
	public List<String> planNames();
	public List<String> planStatus();

}
