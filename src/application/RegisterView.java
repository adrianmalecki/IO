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
                if (verifyUserName(textFieldLogin.getText())) {
                    Facade.registerClient(PESEL, textFieldFirstName.getText(), textFieldLastName.getText(), textFieldPhone.getText(), textFieldEmail.getText(), textFieldPostCode.getText(), textFieldCity.getText(), textFieldAddress.getText(), textFieldIDNumber.getText(), textFieldDrivingLic.getText(), textFieldLogin.getText(), passwordField.getPassword());
                    JOptionPane.showMessageDialog(CheckPeselView.registerFrame,"Pomyślnie zarejestrowano nowego użytkownika!");
                    CheckPeselView.registerFrame.setVisible(false);
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

}
