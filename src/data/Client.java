package data;

import javax.swing.*;

public class Client extends User {

    private String drivingLicenseNumber;

    public Client(String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber, String drivingLicenseNumber, String login, String password) {
        super(login, password, PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber);
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Client() {
    }

    public static boolean checkData(String firstName, String lastName, String phoneNumber, String idNumber, String drivingLicenseNumber){
        if (!(firstName.matches("[a-zA-Z]+"))){
            JOptionPane.showMessageDialog(null, "Niepoprawne dane(IMIĘ).");
            return false;
        }
        if((lastName.length() == 0) || !(lastName.matches("[a-zA-Z]+"))){
            JOptionPane.showMessageDialog(null, "Niepoprawne dane(NAZWISKO).");
            return false;
        }
        if((phoneNumber.length() != 9) || !(phoneNumber.matches("\\d+"))){
            JOptionPane.showMessageDialog(null, "Niepoprawne dane(TELEFON).");
            return false;
        }
        if(idNumber.length() == 0){
            JOptionPane.showMessageDialog(null, "Pole NR DOWODU OSOBISTEGO nie moze być puste.");
            return false;
        }
        if(drivingLicenseNumber.length() == 0){
            JOptionPane.showMessageDialog(null, "Pole NR PRAWA JAZDY nie moze być puste.");
            return false;
        }
        return true;
    }

    public void deleteData() {
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
