package in.amitit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="PLAN_MASTER")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private Integer planId;
	
	@JsonProperty("planName")
	@Column(name="PLAN_NAME")
	private String planName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_BY")
	private String updateBy;
	
	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime  createDate;
	
	@Column(name = "UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDateTime updateDate;

}
