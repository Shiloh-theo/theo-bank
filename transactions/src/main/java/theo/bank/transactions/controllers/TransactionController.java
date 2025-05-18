package theo.bank.transactions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theo.bank.transactions.dto.FrontendTransactionDTO;
import theo.bank.transactions.service.TransactionService;

@RestController
@RequestMapping(path = "bank")
public class TransactionController {

    @Autowired
    TransactionService service;

    @PostMapping("transaction")
    public String makeTransaction(@RequestBody FrontendTransactionDTO dto){
        return service.confirmDetails(dto);
    }
}
