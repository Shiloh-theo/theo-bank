package theo.bank.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theo.bank.users.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
