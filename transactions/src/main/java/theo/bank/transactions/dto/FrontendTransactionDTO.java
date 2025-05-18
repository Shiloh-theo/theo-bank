package theo.bank.transactions.dto;

public class FrontendTransactionDTO {

    String senderAccount;
    String receiverAccount;
    double amount;
    int pin;

    public FrontendTransactionDTO(String senderAccount, String receiverAccount, double amount, int pin) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.pin = pin;
    }

    public FrontendTransactionDTO() {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
