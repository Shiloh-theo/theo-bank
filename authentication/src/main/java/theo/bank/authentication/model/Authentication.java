package theo.bank.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Entity
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int authenticationId;
    String password;
    String email;
    int pin;
    int userId;

    public Authentication(int authenticationId, String password, String email, int pin, int userId) {
        this.authenticationId = authenticationId;
        this.password = password;
        this.email = email;
        this.pin = pin;
        this.userId=userId;
    }

    public Authentication() {
    }

    public int getAuthenticationId() {
        return authenticationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAuthenticationId(int authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
