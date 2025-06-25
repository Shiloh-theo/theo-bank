package theo.bank.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import theo.bank.authentication.model.AuthenticationModel;

@Repository
public interface AuthRepository extends JpaRepository<AuthenticationModel, Integer> {

    @Query("SELECT a.pin FROM AuthenticationModel a WHERE a.userId = :userId")
    public Integer findPinByUserId(int userId);

    public AuthenticationModel findByEmail(String email);
}
