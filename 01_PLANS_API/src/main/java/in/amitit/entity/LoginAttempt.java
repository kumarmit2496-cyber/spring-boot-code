package in.amitit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Plan_Login_Attempt")
public class LoginAttempt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	@Column(name="USERNAME")
    private String username;
	@Column(name = "PASSWORD")
    private String password; // store encoded
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="Mobile_Number")
	private String mobilenumber;
	@Column(name = "ROLE")
    private String role;
	 @Column(name = "STATUS")
    private String status; // "SUCCESS" or "FAILURE"
    @Column(name = "LOCAL_DATE_TIME",updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamp;

}
