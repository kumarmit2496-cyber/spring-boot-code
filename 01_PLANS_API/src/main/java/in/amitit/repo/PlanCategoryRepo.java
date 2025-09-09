package in.amitit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.amitit.entity.PlanCategory;

public interface PlanCategoryRepo  extends  JpaRepository<PlanCategory,Integer> {

}
