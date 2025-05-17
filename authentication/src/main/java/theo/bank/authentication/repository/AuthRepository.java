package theo.bank.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theo.bank.authentication.model.Authentication;

@Repository
public interface AuthRepository extends JpaRepository<Authentication, Integer> {
}
