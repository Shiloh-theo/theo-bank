package theo.bank.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import theo.bank.authentication.model.AuthenticationModel;
import theo.bank.authentication.model.CustomerDetails;
import theo.bank.authentication.repository.AuthRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {


    @Autowired
    AuthRepository repo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AuthenticationModel auth = repo.findByEmail(email);

        return new CustomerDetails(auth);
    }
}
