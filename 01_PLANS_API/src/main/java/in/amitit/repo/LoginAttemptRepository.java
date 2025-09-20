package in.amitit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.amitit.entity.LoginAttempt;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long>{

	Optional<LoginAttempt> findByUsername(String username);

}
