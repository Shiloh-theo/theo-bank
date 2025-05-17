package theo.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theo.bank.account.model.AccountDetails;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Integer> {
    public boolean existsByAccountNumber(String accountNumber);
}
