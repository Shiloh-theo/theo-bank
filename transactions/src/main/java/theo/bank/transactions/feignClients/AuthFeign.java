package theo.bank.transactions.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import theo.bank.transactions.dto.AuthCallDTO;

@FeignClient(name = "Authentication")
public interface AuthFeign {

    @PostMapping("/bank/verifypin")
    public boolean verifyPin(@RequestBody AuthCallDTO dto);
}
