package application;

import data.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDeleting {
    public JPanel deleteDataPanel;
    private JButton yesButton;
    private JButton noButton;
    private JTextField textFieldPassword;
    private JButton deleteButton;
    private JLabel inputPasswordLabel;
    String password;
    //////////////wyrównac SIZE okna
    public ConfirmDeleting(String clientLogin, String clientPassword) {
        System.out.println(clientPassword);
        textFieldPassword.setVisible(false);
        deleteButton.setVisible(false);
        inputPasswordLabel.setVisible(false);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldPassword.setVisible(true);
                deleteButton.setVisible(true);
                inputPasswordLabel.setVisible(true);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //wroc do client view
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientPassword.equals(textFieldPassword.getText())) {
                    for (Client c: Facade.getClientList()) {
                        if(clientLogin.equals(c.getLogin())) {
                            Facade.getClientList().remove(c);
                            JOptionPane.showMessageDialog(null,"Twoje konto zostało usunięte");
                            // zamknąć okna
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Niepoprawne hasło");
                }
            }
        });
    }



    private void createUIComponents() {
        deleteDataPanel = new JPanel();
        yesButton = new JButton();
        noButton = new JButton();
        textFieldPassword = new JTextField();
        deleteButton = new JButton();
        inputPasswordLabel = new JLabel();
    }
}
