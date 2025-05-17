package theo.bank.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.users.dto.*;
import theo.bank.users.feignClients.AccountFeign;
import theo.bank.users.feignClients.AuthFeign;
import theo.bank.users.model.Customer;
import theo.bank.users.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repo;
    private final AccountFeign accountFeign;
    private final AuthFeign authFeign;

    @Autowired
    public CustomerService(CustomerRepository repo, AccountFeign accountFeign, AuthFeign authFeign) {
        this.repo = repo;
        this.accountFeign = accountFeign;
        this.authFeign = authFeign;
    }

    public ResponseEntity<CreatedCustomerDTO> registerUser(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAge(dto.getAge());
        customer.setPhone(dto.getPhone());

        Customer newCustomer = repo.save(customer);

        AuthenticationDTO authDTO = new AuthenticationDTO();
        authDTO.setEmail(dto.getEmail());
        authDTO.setPin(dto.getPin());
        authDTO.setPassword(dto.getPassword());

        authFeign.registerAuth(authDTO);

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(newCustomer.getUserId());
        ResponseEntity<CreatedAccountDTO> createdAccountDTO = accountFeign.createAccount(accountDTO);

        CreatedCustomerDTO createdCustomer = new CreatedCustomerDTO();
        createdCustomer.setPhone(customer.getPhone());
        createdCustomer.setName(customer.getName());
        createdCustomer.setAge(customer.getAge());
        createdCustomer.setCreatedAccountDTO(createdAccountDTO.getBody());
        createdCustomer.setAuthenticationDTO(authDTO);

        return ResponseEntity.ok().body(createdCustomer);
    }
}
