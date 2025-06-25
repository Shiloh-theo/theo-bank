package theo.bank.transactions.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.transactions.dto.*;
import theo.bank.transactions.feignClients.AccountFeign;
import theo.bank.transactions.feignClients.AuthFeign;
import theo.bank.transactions.model.Transactions;
import theo.bank.transactions.repository.TransactionRepository;
import java.util.Map;

@Service
public class TransactionService {

    TransactionRepository repo;
    AccountFeign accountFeign;
    AuthFeign authFeign;

    public TransactionService(TransactionRepository repo, AccountFeign accountFeign, AuthFeign authFeign) {
        this.repo = repo;
        this.accountFeign = accountFeign;
        this.authFeign = authFeign;
    }

    public String confirmDetails(FrontendTransactionDTO dto) {
        AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
        accountTransactionDTO.setReceiverAccount(dto.getReceiverAccount());
        accountTransactionDTO.setSenderAccount(dto.getSenderAccount());

        ReceivedAccountDTO receivedAccountDTO = accountFeign.getAccountIDs(accountTransactionDTO).getBody();

        AuthCallDTO authCallDTO = new AuthCallDTO();
        authCallDTO.setPin(dto.getPin());
        assert receivedAccountDTO != null;
        authCallDTO.setSenderId(receivedAccountDTO.getSenderId());

        ResponseEntity<AuthReceivedDTO> storedPin = authFeign.verifyPin(authCallDTO);

        if (storedPin.equals(dto.getPin()) && receivedAccountDTO != null) {
            makeTransaction(receivedAccountDTO, dto);
        }

        return ResponseEntity.status(200).toString();
    }

    public String makeTransaction(ReceivedAccountDTO receivedAccountDTO, FrontendTransactionDTO dto) {
        double newReceiverBalance = receivedAccountDTO.getReceiverBalance() + dto.getAmount();
        double newSenderBalance = receivedAccountDTO.getSenderBalance() - dto.getAmount();

        ReceivedAccountDTO newReceivedAccountDTO = new ReceivedAccountDTO();
        newReceivedAccountDTO.setReceiverId(receivedAccountDTO.getReceiverId());
        newReceivedAccountDTO.setSenderBalance(newSenderBalance);
        newReceivedAccountDTO.setReceiverBalance(newReceiverBalance);
        newReceivedAccountDTO.setSenderId(receivedAccountDTO.getSenderId());

        accountFeign.saveTransaction(newReceivedAccountDTO);

        Transactions transaction = new Transactions();
        transaction.setAmount(dto.getAmount());
        transaction.setReceiverAccount(dto.getReceiverAccount());
        transaction.setReceiverId(receivedAccountDTO.getReceiverId());
        transaction.setSenderAccount(dto.getSenderAccount());
        transaction.setSenderId(receivedAccountDTO.getSenderId());

        repo.save(transaction);

        return ResponseEntity.status(200).toString();
    }
}