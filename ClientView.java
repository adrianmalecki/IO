package application;

import data.Client;
import data.Department;

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
    private JTextArea IDarea;
    private Client client;
    int clicked = 0;

    private static ArrayList<Client> clientList;
    ArrayList<Department> departmentsList;
    /*      static ArrayList<Vehicle> vehicleList;
     static ArrayList<Department> departmentsList;
     static Client client = new Client();
     public ClientView(ArrayList<Client> clientList,ArrayList<Department> departmentsList,ArrayList<Vehicle> vehicleList) {
         this.clientList = clientList;
         this.vehicleList = vehicleList;
         this.departmentsList = departmentsList;
     }
 */
    public ClientView(final Client client,ArrayList<Department> departmentsList) {
        this.client = client;
        tabbedPane1.addComponentListener(new ComponentAdapter() {
        });
        reservePanel.addComponentListener(new ComponentAdapter() {
        });
        myDataPanel.addComponentListener(new ComponentAdapter() {
        });
        IDtextField.setText(String.valueOf(client.getID()));
        //IDLabel.setText(String.valueOf(client.getID()));
        firstNameTextField.setText(client.getFirstName());
        lastNameTextField.setText(client.getLastName());
        peselNameTextField.setText(String.valueOf(client.getPESEL()));

        modifyDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked==0){editData(e);}
                else{saveData(e);}

            }
        });

    }
    public void editData(ActionEvent e) {

        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        peselNameTextField.setEditable(true);
        modifyDataButton.setText("Zapisz zmiany");
        clicked = 1;
    }
    public void saveData(ActionEvent e) {

        client.setFirstName(firstNameTextField.getText());
        client.setLastName(lastNameTextField.getText());
        client.setPESEL(Integer.parseInt(peselNameTextField.getText()));
        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        peselNameTextField.setEditable(false);
        modifyDataButton.setText("Edytuj dane");
        clicked=0;
    }

    public void editData() {
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

    }
}