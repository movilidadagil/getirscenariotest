package pageobjects.android;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */

public class Customer {
    public String email;
    public String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer() {

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
}
