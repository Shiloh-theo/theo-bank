package theo.bank.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.authentication.dto.AuthCallDTO;
import theo.bank.authentication.dto.AuthReceivedDTO;
import theo.bank.authentication.repository.AuthRepository;

@Service
public class TransactionAuthenticationService {

    @Autowired
    AuthRepository repo;

    public ResponseEntity<AuthReceivedDTO> verifyPin(AuthCallDTO dto) {

        AuthReceivedDTO authReceivedDTO = new AuthReceivedDTO();
        authReceivedDTO.setStoredPin(repo.findPinByUserId(dto.getSenderId()));

        return ResponseEntity.ok(authReceivedDTO);
    }
}
