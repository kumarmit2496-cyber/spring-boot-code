package in.amitit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.amitit.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
