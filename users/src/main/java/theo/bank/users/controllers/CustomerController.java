package theo.bank.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.bank.users.dto.CreatedCustomerDTO;
import theo.bank.users.dto.CustomerDTO;
import theo.bank.users.service.CustomerService;

@RestController
@RequestMapping(path = "bank")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("register")
    public ResponseEntity<CreatedCustomerDTO> registerUser(@RequestBody CustomerDTO dto){
        return service.registerUser(dto);
    }

    @GetMapping("test")
    public String test(){
        return "successful";
    }
}
