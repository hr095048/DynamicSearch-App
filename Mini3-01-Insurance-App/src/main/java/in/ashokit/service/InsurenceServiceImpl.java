package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.request.SearchRequest;
import in.ashokit.bindings.responce.PlanResponce;
import in.ashokit.entity.InsurancePlanEntity;
import in.ashokit.repositories.InsuranceRepo;

@Service
public class InsurenceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceRepo repo;

	@Override
	public List<PlanResponce> search(SearchRequest request) {
		InsurancePlanEntity entity = new InsurancePlanEntity();
		if (request!=null && request.getPlanName() != null && !request.getPlanName().equals("")) {
			entity.setPlanName(request.getPlanName());
		}

		if (request!=null && request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		Example<InsurancePlanEntity> of = Example.of(entity);
		List<InsurancePlanEntity> findAll = repo.findAll(of);
		
		List<PlanResponce> list = new ArrayList<>();
		for (InsurancePlanEntity plan : findAll) {
			PlanResponce pr = new PlanResponce();
			BeanUtils.copyProperties(plan, pr);
			list.add(pr);

		}
		return list;
	}

	@Override
	public List<String> planNames() {
		
		return repo.getplanName();
	}

	@Override
	public List<String> planStatus() {
		return repo.getplanStatus();
	}

}
