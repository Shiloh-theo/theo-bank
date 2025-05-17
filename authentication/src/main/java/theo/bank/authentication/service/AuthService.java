package theo.bank.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.authentication.dto.AuthenticationDTO;
import theo.bank.authentication.model.Authentication;
import theo.bank.authentication.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    AuthRepository repo;

    public ResponseEntity<AuthenticationDTO> registerAuth(AuthenticationDTO dto) {

        Authentication auth = new Authentication();
        auth.setPassword(dto.getPassword());
        auth.setEmail(dto.getEmail());
        auth.setPin(dto.getPin());

        repo.save(auth);

        return ResponseEntity.ok().body(dto);
    }
}
