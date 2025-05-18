package theo.bank.account.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import theo.bank.account.model.AccountDetails;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Integer> {
    public boolean existsByAccountNumber(String accountNumber);

    @Query("SELECT a.userId FROM AccountDetails a WHERE a.accountNumber = :accountNumber")
    Integer findUserIdByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query("SELECT a.balance FROM AccountDetails a WHERE a.accountNumber = :accountNumber")
    Double findBalanceByAccountNumber(String accountNumber);

    @Transactional
    @Modifying
    @Query("UPDATE AccountDetails a SET a.balance = :balance WHERE a.userId = :userId")
    void updateBalanceByAccountNumber(@Param("balance") double balance, @Param("userId") int userId);

}
