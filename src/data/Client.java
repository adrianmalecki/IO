package data;

public class Client extends User {

    private String drivingLicenseNumber;
    private String login;
    private String password;

    public Client(String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber, String drivingLicenseNumber, String login, String password) {
        super(PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.login = login;
        this.password = password;
    }

    public Client() {
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

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
