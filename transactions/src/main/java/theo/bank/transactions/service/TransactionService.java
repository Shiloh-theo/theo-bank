package theo.bank.transactions.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import theo.bank.transactions.dto.AccountTransactionDTO;
import theo.bank.transactions.dto.AuthCallDTO;
import theo.bank.transactions.dto.FrontendTransactionDTO;
import theo.bank.transactions.dto.ReceivedAccountDTO;
import theo.bank.transactions.feignClients.AccountFeign;
import theo.bank.transactions.feignClients.AuthFeign;
import theo.bank.transactions.repository.TransactionRepository;

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

        AuthCallDTO authCallDTO =new AuthCallDTO();

        authCallDTO.setPin(dto.getPin());
        assert receivedAccountDTO != null;
        authCallDTO.setSenderId(receivedAccountDTO.getSenderId());

        boolean verified = authFeign.verifyPin(authCallDTO);

        if(verified && receivedAccountDTO != null){
           makeTransaction(receivedAccountDTO, dto);
        }

        return ResponseEntity.status(200).toString();
    }

    public String makeTransaction(ReceivedAccountDTO receivedAccountDTO, FrontendTransactionDTO dto){
        double newReceiverBalance = receivedAccountDTO.getReceiverBalance() + dto.getAmount();
        double newSenderBalance = receivedAccountDTO.getSenderBalance() - dto.getAmount();
        receivedAccountDTO.setReceiverBalance(newReceiverBalance);
        receivedAccountDTO.setSenderBalance(newSenderBalance);

        ReceivedAccountDTO newReceivedAccountDTO = new ReceivedAccountDTO();
        newReceivedAccountDTO.setReceiverId(receivedAccountDTO.getReceiverId());
        newReceivedAccountDTO.setSenderBalance(newSenderBalance);
        newReceivedAccountDTO.setReceiverBalance(newReceiverBalance);
        newReceivedAccountDTO.setSenderId(receivedAccountDTO.getSenderId());

        return ResponseEntity.status(200).toString();
    }
}
