package in.amitit.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import in.amitit.entity.LoginAttempt;
import in.amitit.entity.Plan;


public interface PlanService {
	
  
	public ResponseEntity<?> login(LoginAttempt loginRequest);
	
	public 	Map<Integer, String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer planId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);
	
	public boolean planStatusChange(Integer planId,String status);

	public void save(LoginAttempt newUser);

	public Optional<LoginAttempt> findByUsername(String username);

}
