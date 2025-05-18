package theo.bank.account.dto;

public class ReceivedAccountDTO {

    int senderId;
    int receiverId;
    double senderBalance;
    double receiverBalance;

    public ReceivedAccountDTO(int senderId, int receiverId, double senderBalance, double receiverBalance) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderBalance = senderBalance;
        this.receiverBalance = receiverBalance;
    }

    public ReceivedAccountDTO() {
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public double getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(double senderBalance) {
        this.senderBalance = senderBalance;
    }

    public double getReceiverBalance() {
        return receiverBalance;
    }

    public void setReceiverBalance(double receiverBalance) {
        this.receiverBalance = receiverBalance;
    }
}
