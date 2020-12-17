package application;

import data.Client;
import data.Department;
import data.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;

import javax.swing.*;

public class ClientView {
    public JPanel clientPanel;
    private JTabbedPane tabbedPane1;
    private JPanel reservePanel;
    private JPanel myDataPanel;
    private JLabel IDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel peselLabel;
    private JButton modifyDataButton;
    private JTextField IDtextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField peselNameTextField;
    private JComboBox comboBox;
    private JTextField startDateTextField;
    private JTextField endDateTextField;
    private JLabel inputDate;
    private JButton showAvaiableCarsBtn;
    private JTable carsTable;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField postCodeTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private Client client;
    int clicked = 0;
    int selected_dep = -1;


    public ClientView(Client client) {
        tabbedPane1.addComponentListener(new ComponentAdapter() {
        });
        reservePanel.addComponentListener(new ComponentAdapter() {
        });
        myDataPanel.addComponentListener(new ComponentAdapter() {
        });
        IDtextField.setText(String.valueOf(Facade.getClientList().indexOf(client)));
        firstNameTextField.setText(client.getFirstName());
        lastNameTextField.setText(client.getLastName());
        peselNameTextField.setText(client.getPESEL());
        addressTextField.setText(client.getAddress());
        cityTextField.setText(client.getCity());
        postCodeTextField.setText(client.getPostCode());
        emailTextField.setText(client.getEmail());
        phoneTextField.setText(client.getPhoneNumber());
        startDateTextField.setVisible(false);
        endDateTextField.setVisible(false);
        inputDate.setVisible(false);
        showAvaiableCarsBtn.setVisible(false);
        carsTable.setVisible(false);


        modifyDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked==0) editData(e);
                else {
                    Facade.modifyData(client, firstNameTextField.getText(), lastNameTextField.getText(), phoneTextField.getText(), emailTextField.getText(), postCodeTextField.getText(), cityTextField.getText(), addressTextField.getText());
                    saveData(e);
                }
            }
        });



        showAvaiableCarsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }
    public void editData(ActionEvent e) {

        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        addressTextField.setEditable(true);
        cityTextField.setEditable(true);
        postCodeTextField.setEditable(true);
        emailTextField.setEditable(true);
        phoneTextField.setEditable(true);
        modifyDataButton.setText("Zapisz zmiany");
        clicked = 1;
    }
    public void saveData(ActionEvent e) {

        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        addressTextField.setEditable(false);
        cityTextField.setEditable(false);
        postCodeTextField.setEditable(false);
        emailTextField.setEditable(false);
        phoneTextField.setEditable(false);
        modifyDataButton.setText("Edytuj dane");
        clicked=0;
    }

    public void deleteData() {
    }

    public void cancelReservation() {
    }

    public void chooseDepartment() {

    }

    public void showReservations() {
    }

    public void reserveCar() {

    }

    private void createUIComponents() {
        tabbedPane1 = new JTabbedPane();
        startDateTextField = new JTextField();
        endDateTextField = new JTextField();
        inputDate = new JLabel();
        showAvaiableCarsBtn = new JButton();
        carsTable = new JTable();
    }
}
