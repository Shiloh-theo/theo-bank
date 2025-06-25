package theo.bank.transactions.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import theo.bank.transactions.dto.AccountTransactionDTO;
import theo.bank.transactions.dto.ReceivedAccountDTO;

@FeignClient(name = "account")
public interface AccountFeign {

    @PostMapping("bank/getIds")
    public ResponseEntity<ReceivedAccountDTO> getAccountIDs(@RequestBody AccountTransactionDTO dto);

    @PutMapping("bank/savetransaction")
    public boolean saveTransaction(@RequestBody ReceivedAccountDTO dto);
}
