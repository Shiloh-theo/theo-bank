package theo.bank.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import theo.bank.users.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
