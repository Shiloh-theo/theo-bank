package theo.bank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.account.dto.AccountDTO;
import theo.bank.account.dto.CreatedAccountDTO;
import theo.bank.account.model.AccountDetails;
import theo.bank.account.repository.AccountRepository;

import java.util.Random;

@Service
public class AccountService {

    @Autowired
    AccountRepository repo;

    public ResponseEntity<CreatedAccountDTO> createAccount(AccountDTO dto) {

        String accountNumber;
        do{
            accountNumber = generateAccountNumber();
        } while(repo.existsByAccountNumber(accountNumber));

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setBalance(0);
        accountDetails.setAccountNumber(accountNumber);
        accountDetails.setUserId(dto.getUserId());

        repo.save(accountDetails);

        CreatedAccountDTO createdAccount = new CreatedAccountDTO();
        createdAccount.setAccountNumber(accountNumber);
        createdAccount.setBalance(0);

        return ResponseEntity.ok(createdAccount);
    }

    public String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10); // 0 to 9
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }
}
