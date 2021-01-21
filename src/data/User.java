package data;

import application.Facade;

import javax.swing.*;

public class User {

    private String login;
    private String password;
    private String PESEL;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String postCode;
    private String city;
    private String address;
    private String identityCardNumber;

    public User(String login, String password, String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber) {
        this.login = login;
        this.password = password;
        this.PESEL = PESEL;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.postCode = postCode;
        this.city = city;
        this.address = address;
        this.identityCardNumber = identityCardNumber;
    }

    public User() {
    }

    /*public static int checkLoginData(String login, String password){
        Facade facade = new Facade();
        for (Client c: facade.getClientArrayList()) {
            if(login.equals(c.getLogin())) {
                if (password.equals(c.getPassword())) {
                    return facade.getClientArrayList().indexOf(c);
                }
            }
        }
        return -1;
    }*/

    public static int checkLoginData(String login, String password){   // version for Mockito...
        for (Client c: Facade.getClientArrayList()) {
            if(login.equals(c.getLogin())) {
                if (password.equals(c.getPassword())) {
                    return Facade.getClientArrayList().indexOf(c);
                }
            }
        }
        return -1;
    }

    public static boolean verifyUserName(String login){
        for (Client c: Facade.getClientList()) {
            if(login.equals(c.getLogin())) {
                JOptionPane.showMessageDialog(null,"Wybierz inny login");
                return false;
            }
        }
        return true;
    }

    public static boolean verifyPassword(char[] password){
        if(password.length < 8) {
            JOptionPane.showMessageDialog(null, "Hasło za krótkie");
            return false;
        }
        return true;
    }

    public static boolean checkPESEL(String PESEL) {
        for (Client c:Facade.getClientList()) {
            if(PESEL.equals(c.getPESEL())) {
                return true;
            }
        }
        return false;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }
}
