package testyfitnessefixture;

import fit.ColumnFixture;

import java.util.IllegalFormatCodePointException;

public class TestRejestracjaKlienta extends ColumnFixture {
    private String[] dane;
    String PESEL;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String postCode;
    String city;
    String address;
    String identityCardNumber;
    String drivingLicenseNumber;
    String login;
    String password;

    public boolean registerClientTest() throws IllegalFormatCodePointException {
        try {
            if (SetUp.client.checkPESEL(getDane()[0])) {
                if (SetUp.client.verifyUserName(getDane()[10]) && SetUp.client.verifyPassword(getDane()[11].toCharArray()) && SetUp.client.checkData(getDane()[1], getDane()[2], getDane()[3], getDane()[8], getDane()[9])) {
                    SetUp.application.registerClient(getDane()[0], getDane()[1], getDane()[2], getDane()[3], getDane()[4], getDane()[5], getDane()[6], getDane()[7], getDane()[8], getDane()[9], getDane()[10], getDane()[11].toCharArray());
                    return true;
                }
                else return false;
            }
            else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String[] getDane() {
        return dane;
    }

    public void setDane(String[] dane) {
        this.dane = dane;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
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
}
