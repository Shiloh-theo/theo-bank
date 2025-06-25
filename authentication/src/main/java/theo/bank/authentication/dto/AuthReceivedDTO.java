package theo.bank.authentication.dto;

public class AuthReceivedDTO {

    int storedPin;

    public AuthReceivedDTO(int storedPin) {
        this.storedPin = storedPin;
    }

    public AuthReceivedDTO() {
    }

    public int getStoredPin() {
        return storedPin;
    }

    public void setStoredPin(int storedPin) {
        this.storedPin = storedPin;
    }
}
