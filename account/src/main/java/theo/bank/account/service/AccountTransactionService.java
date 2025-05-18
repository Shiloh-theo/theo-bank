package theo.bank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.account.dto.AccountTransactionDTO;
import theo.bank.account.dto.ReceivedAccountDTO;
import theo.bank.account.model.AccountDetails;
import theo.bank.account.repository.AccountRepository;

@Service
public class AccountTransactionService {

    @Autowired
    AccountRepository repo;

    public ResponseEntity<ReceivedAccountDTO> getAccountIDs(AccountTransactionDTO dto) {

        int senderId = repo.findUserIdByAccountNumber(dto.getSenderAccount());
        int receiverId = repo.findUserIdByAccountNumber(dto.getReceiverAccount());
        double senderBalance = repo.findBalanceByAccountNumber(dto.getSenderAccount());
        double receiverBalance = repo.findBalanceByAccountNumber(dto.getReceiverAccount());

        ReceivedAccountDTO receivedAccounts = new ReceivedAccountDTO();
        receivedAccounts.setReceiverBalance(receiverBalance);
        receivedAccounts.setReceiverId(receiverId);
        receivedAccounts.setSenderBalance(senderBalance);
        receivedAccounts.setSenderId(senderId);

        return ResponseEntity.ok(receivedAccounts);
    }

    public String saveTransaction(ReceivedAccountDTO dto) {

        repo.updateBalanceByAccountNumber(dto.getReceiverBalance(), dto.getReceiverId());
        repo.updateBalanceByAccountNumber(dto.getSenderBalance(), dto.getSenderId());

        return ResponseEntity.status(200).toString();
    }
}
