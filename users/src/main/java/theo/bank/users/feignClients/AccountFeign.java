package theo.bank.users.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import theo.bank.users.dto.AccountDTO;
import theo.bank.users.dto.CreatedAccountDTO;

@FeignClient(name = "account")
public interface AccountFeign {

    @PostMapping("bank/createAccount")
    public ResponseEntity<CreatedAccountDTO> createAccount(@RequestBody AccountDTO dto);
}
