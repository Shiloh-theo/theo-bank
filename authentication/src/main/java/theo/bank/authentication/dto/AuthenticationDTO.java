package theo.bank.authentication.dto;

public class AuthenticationDTO {

    String email;
    String password;
    int pin;

    public AuthenticationDTO(String email, String password, int pin) {
        this.email = email;
        this.password = password;
        this.pin = pin;
    }

    public AuthenticationDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
