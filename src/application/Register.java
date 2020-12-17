package application;

import data.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {


    public JPanel registerPanel;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldPESEL;
    private JTextField textFieldIDNumber;
    private JButton registerButton;
    Client client;

    public Register(Client client) {
        this.client = client;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.setClientID(24);
                client.setFirstName(textFieldFirstName.getText());
                client.setLastName(textFieldLastName.getText());
                client.setPESEL(Integer.parseInt(textFieldPESEL.getText()));
                client.setIdentityCardNumber(Integer.parseInt(textFieldIDNumber.getText()));
            }
        });
    }


    private void createUIComponents() {
        textFieldFirstName = new JTextField();
        textFieldLastName = new JTextField();
        textFieldPESEL = new JTextField();
        textFieldIDNumber = new JTextField();
        registerButton = new JButton();
    }
}
