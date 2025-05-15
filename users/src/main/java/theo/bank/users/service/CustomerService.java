package theo.bank.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.users.dto.CreatedCustomerDTO;
import theo.bank.users.dto.CustomerDTO;
import theo.bank.users.model.User;
import theo.bank.users.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repo;
//
//    @Autowired
//    CreatedCustomerDTO createdCustomerDTO;


    public ResponseEntity<User> registerUser(CustomerDTO dto) {

       User user = convertToEntity(dto);

       repo.save(user);

//        createdCustomerDTO.setAge(savedUser.getAge());
//        createdCustomerDTO.setName();
//        createdCustomerDTO.setPassword();
//        createdCustomerDTO.setEmail();
//        createdCustomerDTO.setPin();
//        createdCustomerDTO.setPhone();
//        createdCustomerDTO.setBalance();
//        createdCustomerDTO.setAccountNumber();
//
        return ResponseEntity.ok().body(user);
    }

    public User convertToEntity(CustomerDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());

//        repo.save(user);
//
        return user;
    }
}
