package theo.bank.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import theo.bank.authentication.model.Authentication;

@Repository
public interface AuthRepository extends JpaRepository<Authentication, Integer> {

    @Query("SELECT a.pin FROM Authentication a WHERE a.userId = :userId")
    public Integer findPinByUserId(int userId);
}
