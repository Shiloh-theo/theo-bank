package theo.bank.users.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import theo.bank.users.dto.AuthenticationDTO;

@FeignClient(name = "authentication")
public interface AuthFeign {


    @PostMapping("/bank/registerAuth")
    public ResponseEntity<AuthenticationDTO> registerAuth(@RequestBody AuthenticationDTO dto);
}
