package theo.bank.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theo.bank.authentication.dto.AuthenticationDTO;
import theo.bank.authentication.service.AuthService;

@RestController
@RequestMapping(path = "bank")
public class AuthenticationController {

    @Autowired
    AuthService service;

    @PostMapping("registerAuth")
    public ResponseEntity<AuthenticationDTO> registerAuth(@RequestBody AuthenticationDTO dto){
        return service.registerAuth(dto);
    }
}
