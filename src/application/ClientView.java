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
    private Client client;
    int clicked = 0;
    int selected_dep = -1;

    private static ArrayList<Client> clientList;
    ArrayList<Department> departmentsList;
    ArrayList<Vehicle> vehicleList;/*
     static ArrayList<Department> departmentsList;
     static Client client = new Client();
     public ClientView(ArrayList<Client> clientList,ArrayList<Department> departmentsList,ArrayList<Vehicle> vehicleList) {
         this.clientList = clientList;
         this.vehicleList = vehicleList;
         this.departmentsList = departmentsList;
     }
 */
    public ClientView(final Client client,ArrayList<Department> departmentsList, ArrayList<Vehicle> vehicleList) {
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
        startDateTextField.setVisible(false);
        endDateTextField.setVisible(false);
        inputDate.setVisible(false);
        showAvaiableCarsBtn.setVisible(false);
        carsTable.setVisible(false);
        for (Department d:departmentsList) {
            String dep = d.getDepartmentID() + " " + d.getCity() + " " + d.getAddress();
            comboBox.addItem(dep);
        }


        modifyDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked==0){editData(e);}
                else{saveData(e);}

            }
        });


        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected_dep = comboBox.getSelectedIndex() + 1;
                if(selected_dep != -1){
                    System.out.println(selected_dep);

                    startDateTextField.setVisible(true);
                    endDateTextField.setVisible(true);
                    inputDate.setVisible(true);
                    showAvaiableCarsBtn.setVisible(true);
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