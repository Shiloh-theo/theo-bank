package theo.bank.transactions.dto;

public class AccountTransactionDTO {

    String senderAccount;
    String receiverAccount;

    public AccountTransactionDTO(String senderAccount, String receiverAccount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public AccountTransactionDTO() {
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }
}
