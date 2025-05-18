package theo.bank.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.bank.account.dto.AccountTransactionDTO;
import theo.bank.account.dto.ReceivedAccountDTO;
import theo.bank.account.service.AccountTransactionService;

@RestController
@RequestMapping(path = "bank")
public class AccountTransactionController {

    @Autowired
    AccountTransactionService service;

    @PostMapping("getIds")
    public ResponseEntity<ReceivedAccountDTO> getAccountIDs(@RequestBody AccountTransactionDTO dto){
        return service.getAccountIDs(dto);
    }

    @PutMapping("savetransaction")
    public String saveTransaction(@RequestBody ReceivedAccountDTO dto){
        return service.saveTransaction(dto);
    }
}
