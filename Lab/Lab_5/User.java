package Lab.Lab_5;

public class User implements ValidatePhone {
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber) throws WrongPhoneNumberException {
        this.username = username;
        this.password = password;
        setPhoneNumber(phoneNumber);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
