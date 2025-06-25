package theo.bank.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.bank.authentication.dto.AuthenticationDTO;
import theo.bank.authentication.dto.LoginDTO;
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

    @PostMapping("login")
    public String login(@RequestBody LoginDTO dto){
        return service.login(dto);
    }

    @GetMapping("test")
    public String test(){
        return "successful";
    }
}
