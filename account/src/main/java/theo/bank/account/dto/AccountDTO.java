package theo.bank.account.dto;

public class AccountDTO {

    int userId;

    public AccountDTO(int userId) {
        this.userId = userId;
    }

    public AccountDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
