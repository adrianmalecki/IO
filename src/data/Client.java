package data;

public class Client extends User {

    private int clientID;
    private String drivingLicenseNumber;
    private String login;
    private String password;

    public Client(int userID, int PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, int identityCardNumber, int clientID, String drivingLicenseNumber, String login, String password) {
        super(userID, PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber);
        this.clientID = clientID;
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
