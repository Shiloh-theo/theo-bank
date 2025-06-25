package theo.bank.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.bank.authentication.dto.AuthCallDTO;
import theo.bank.authentication.dto.AuthReceivedDTO;
import theo.bank.authentication.service.TransactionAuthenticationService;
import java.util.Map;

@RestController
@RequestMapping(path = "bank")
public class TransactionAuthenticationController {

    @Autowired
    TransactionAuthenticationService service;

    @PostMapping("verifypin")
    public ResponseEntity<AuthReceivedDTO> verifyPin(@RequestBody AuthCallDTO dto) {

        return service.verifyPin(dto);
    }
}