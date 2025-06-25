package theo.bank.transactions.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import theo.bank.transactions.dto.AuthCallDTO;
import theo.bank.transactions.dto.AuthReceivedDTO;


@FeignClient(name = "authentication")
public interface AuthFeign {

    @PostMapping("bank/verifypin")
    public ResponseEntity<AuthReceivedDTO> verifyPin(@RequestBody AuthCallDTO dto);
}