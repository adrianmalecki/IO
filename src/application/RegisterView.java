package application;

import data.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView {

    public JPanel registerPanel;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldEmail;
    private JTextField textFieldIDNumber;
    private JButton registerButton;
    private JTextField textFieldLogin;
    private JPasswordField passwordField;
    private JTextField textFieldDrivingLic;
    private JTextField textFieldPhone;
    private JTextField textFieldAddress;
    private JTextField textFieldCity;
    private JTextField textFieldPostCode;

    public RegisterView(String PESEL) {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verifyUserName(textFieldLogin.getText()) && verifyPassword(passwordField.getPassword()) && checkData(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldPhone.getText(), textFieldIDNumber.getText(), textFieldDrivingLic.getText())) {
                    Facade.registerClient(PESEL, textFieldFirstName.getText(), textFieldLastName.getText(), textFieldPhone.getText(), textFieldEmail.getText(), textFieldPostCode.getText(), textFieldCity.getText(), textFieldAddress.getText(), textFieldIDNumber.getText(), textFieldDrivingLic.getText(), textFieldLogin.getText(), passwordField.getPassword());
                    CheckPeselView.registerFrame.setVisible(false);
                    JOptionPane.showMessageDialog(CheckPeselView.registerFrame,"Pomyślnie zarejestrowano nowego użytkownika!");
                    SignInPanel.signInFrame.setContentPane(new SignInPanel().loginPanel);
                    SignInPanel.signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    SignInPanel.signInFrame.pack();
                    SignInPanel.signInFrame.setVisible(true);
                }
            }
        });
    }

    private boolean verifyUserName(String login){
        for (Client c: Facade.getClientList()) {
            if(login.equals(c.getLogin())) {
                JOptionPane.showMessageDialog(null,"Wybierz inny login");
                return false;
            }
        }
        return true;
    }

    private boolean verifyPassword(char [] password){
        if(password.length < 8) {
            JOptionPane.showMessageDialog(null, "Hasło za krótkie");
            return false;
        }
        return true;
    }

    private boolean checkData(String firstName, String lastName, String phoneNumber, String idNumber, String drivingLicenseNumber){
        if((firstName.length() == 0)/* || !(firstName.matches("[A-Za-z]"))*/){
            JOptionPane.showMessageDialog(null, "Niepoprawne dane(IMIĘ).");
            return false;
        }
        if((lastName.length() == 0)/* || !(lastName.matches("[A-Za-z]"))*/){
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

}
