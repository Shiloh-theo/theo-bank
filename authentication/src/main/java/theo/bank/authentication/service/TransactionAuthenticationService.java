package theo.bank.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import theo.bank.authentication.dto.AuthCallDTO;
import theo.bank.authentication.repository.AuthRepository;

@Service
public class TransactionAuthenticationService {

    @Autowired
    AuthRepository repo;

    public boolean verifyPin(AuthCallDTO dto) {

        int receivedPin = dto.getPin();
        int storedPin = repo.findPinByUserId(dto.getSenderId());
        return receivedPin == storedPin;
    }
}
