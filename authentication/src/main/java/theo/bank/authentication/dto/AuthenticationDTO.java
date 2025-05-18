package theo.bank.authentication.dto;

public class AuthenticationDTO {

    String email;
    String password;
    int pin;
    int userId;

    public AuthenticationDTO(String email, String password, int pin, int userId) {
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.userId=userId;
    }

    public AuthenticationDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
