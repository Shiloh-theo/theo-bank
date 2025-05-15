package theo.bank.users.dto;

public class CreatedCustomerDTO {

    String name;
    String email;
    String password;
    int pin;
    String age;
    String phone;
    String accountNumber;
    double balance;

    public CreatedCustomerDTO(String name, String email, String password, int pin, String age, String phone, String accountNumber, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.pin = pin;
        this.age = age;
        this.phone = phone;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public CreatedCustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
