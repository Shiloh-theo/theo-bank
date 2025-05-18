package theo.bank.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theo.bank.transactions.model.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {

}
