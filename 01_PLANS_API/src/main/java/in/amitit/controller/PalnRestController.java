package in.amitit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.amitit.entity.LoginAttempt;
import in.amitit.entity.Plan;
import in.amitit.service.PlanService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/plans")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class PalnRestController {
	
	@Autowired
	private PlanService planService;
	
	
	/*
	 * @Autowired private UserRepository userRepository;
	 */
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		log.info("get All categories");
		  Map<Integer, String> planCategories = planService.getPlanCategories();
		  return new ResponseEntity<>(planCategories,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Plan>> plans(){
		 //  List<Plan> allPlans = planService.getAllPlans();
		//   return new ResponseEntity<>(allPlans,HttpStatus.OK);
		log.info("get All plan");
		return ResponseEntity.ok(planService.getAllPlans());
	}
	
	@GetMapping("/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId){
		   //    Plan planById = planService.getPlanById(planId);
		    //   return new ResponseEntity<>(planById,HttpStatus.OK);
		log.info("get Plan By Id");
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
		log.info("saving the plans");
		 boolean saved = planService.savePlan(plan);
			   return saved
					   ?new ResponseEntity<>("Plan Saved",HttpStatus.CREATED)
						:new ResponseEntity<>("Plan not Saved",HttpStatus.BAD_REQUEST);     
					   
					 
     }
	
		
		/*
		 * @PostMapping("/login") public ResponseEntity<?> login(@RequestBody User
		 * loginRequest) { return
		 * userRepository.findByUsername(loginRequest.getUsername()) .map(user -> { if
		 * (user.getPassword().equals(loginRequest.getPassword())) { return
		 * ResponseEntity.ok("Login Successful"); } else { return
		 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Password"); } })
		 * .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found")
		 * ); }
		 */
		 

	/*
	 * @PostMapping("/Userlogin") public ResponseEntity<?> Userlogin(@RequestBody
	 * User loginRequest) { return planService.login(loginRequest); }
	 */
      
	  @PostMapping("/Register")
	  public ResponseEntity<?> register(@RequestBody LoginAttempt newUser){
		  log.info("users are registering");
		  Optional<LoginAttempt> existingUser=planService.findByUsername(newUser.getUsername());
		  if(existingUser.isPresent()) {
			  return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserName alreday exist");
		  }
			 
		  planService.save(newUser);
		  
		return ResponseEntity.status(HttpStatus.CREATED).body("User Register Suceesfully");
		  
	  }
	
	  @PostMapping("/login")
	  public ResponseEntity<?> login(@RequestBody LoginAttempt loginRequest){
		  log.info("usere login");
		   Optional<LoginAttempt>  userlogin=planService.findByUsername(loginRequest.getUsername());
		   
		   if(userlogin.isEmpty()) {
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found, Please register");
		   }
		   
		   LoginAttempt user=userlogin.get();
		   
		   if(user.getPassword()==null||user.getPassword().trim().isEmpty()) {
			   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password is not avilable");
		   }
		   if(user.getPassword().equals(loginRequest.getPassword())) {
			   return ResponseEntity.ok("Login Succesful");
		   }
		  else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inavlid Password");
		}
		  
	  }
	  
	  

	
	 @PutMapping
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		 log.info("users updating plan");
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
		 
		   log.info("delete plan");
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
		log.info("checking plans status");
		  boolean changed = planService.planStatusChange(planId, status);
		return changed
				?ResponseEntity.ok("Status Chnaged")
				:ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status not chnaged");		
}}
