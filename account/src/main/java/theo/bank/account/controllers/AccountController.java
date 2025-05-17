package theo.bank.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theo.bank.account.dto.AccountDTO;
import theo.bank.account.dto.CreatedAccountDTO;
import theo.bank.account.service.AccountService;

@RestController
@RequestMapping(path = "bank")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("createAccount")
    public ResponseEntity<CreatedAccountDTO> createAccount(@RequestBody AccountDTO dto){
        return service.createAccount(dto);
    }

}
