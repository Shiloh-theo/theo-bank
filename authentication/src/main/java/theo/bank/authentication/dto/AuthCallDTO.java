package theo.bank.authentication.dto;

public class AuthCallDTO {

    int senderId;
    int pin;

    public AuthCallDTO(int senderId, int pin) {
        this.senderId = senderId;
        this.pin = pin;
    }

    public AuthCallDTO() {
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
