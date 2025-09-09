package in.amitit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.amitit.entity.Plan;
import in.amitit.service.PlanService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "http://localhost:4200")
public class PalnRestController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		  Map<Integer, String> planCategories = planService.getPlanCategories();
		  return new ResponseEntity<>(planCategories,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Plan>> plans(){
		 //  List<Plan> allPlans = planService.getAllPlans();
		//   return new ResponseEntity<>(allPlans,HttpStatus.OK);
		return ResponseEntity.ok(planService.getAllPlans());
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId){
		   //    Plan planById = planService.getPlanById(planId);
		    //   return new ResponseEntity<>(planById,HttpStatus.OK);	
		return ResponseEntity.ok(planService.getPlanById(planId));
		
	}
	
	
	@PostMapping
     public ResponseEntity<String> savePlan(@RequestBody Plan plan){
			/*
			 * String responseMsg=""; boolean issaved = planService.savePlan(plan);
			 * System.out.println("Incoming plan: " + plan); if(issaved) {
			 * responseMsg="Plan Saved"; } else { responseMsg="Plan Not Saved"; }
			 *   new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
			 */
		 boolean saved = planService.savePlan(plan);
			   return saved
					   ?new ResponseEntity<>("Plan Saved",HttpStatus.CREATED)
						:new ResponseEntity<>("Plan not Saved",HttpStatus.BAD_REQUEST);     
					   
					 
     }
	

	

	
	 @PutMapping
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		/*
		 * boolean updatePlan = planService.updatePlan(plan); String msg="";
		 * if(updatePlan) { msg="Plan Updated"; }else { msg="Plan not updated"; }
		 */
		//return new ResponseEntity<>(msg,HttpStatus.OK);
		   boolean updated = planService.updatePlan(plan);
		 return updated
				 ?ResponseEntity.ok("update plan")
				:ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Plan not updated");	 
		   
	}
	
	 @DeleteMapping("/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		/*
		 * boolean deletePlanById = planService.deletePlanById(planId); String msg="";
		 * if(deletePlanById) { msg="Plan Deleted"; } else { msg="Paln not deleted"; }
		 * return new ResponseEntity<>(msg,HttpStatus.OK);
		 */
		 
		 
		   boolean deleted = planService.deletePlanById(planId);
		 return deleted
				 ?ResponseEntity.ok("Plan Deleted")
				:ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Plan not deleted");		 
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChnage(@PathVariable Integer planId,@PathVariable String status){
	/*	String msg="";
	boolean planStatusChange = planService.planStatusChange(planId, status);
	
	if(planStatusChange) {
		msg="Status Chnaged";
	}
	else {
		msg="Status not chnages";
	}
	return new ResponseEntity<>(msg,HttpStatus.OK);
	}*/
		
		  boolean changed = planService.planStatusChange(planId, status);
		return changed
				?ResponseEntity.ok("Status Chnaged")
				:ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status not chnaged");		
}}
