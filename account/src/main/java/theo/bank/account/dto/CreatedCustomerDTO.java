package theo.bank.account.dto;

public class CreatedCustomerDTO {

    String name;
    String age;
    String phone;
    AuthenticationDTO authenticationDTO;
    CreatedAccountDTO createdAccountDTO;

    public CreatedCustomerDTO(String name, String age, String phone, AuthenticationDTO authenticationDTO, CreatedAccountDTO createdAccountDTO) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.authenticationDTO = authenticationDTO;
        this.createdAccountDTO = createdAccountDTO;
    }

    public CreatedCustomerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public AuthenticationDTO getAuthenticationDTO() {
        return authenticationDTO;
    }

    public void setAuthenticationDTO(AuthenticationDTO authenticationDTO) {
        this.authenticationDTO = authenticationDTO;
    }

    public CreatedAccountDTO getCreatedAccountDTO() {
        return createdAccountDTO;
    }

    public void setCreatedAccountDTO(CreatedAccountDTO createdAccountDTO) {
        this.createdAccountDTO = createdAccountDTO;
    }
}
