package application;

import data.Client;

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
    private Client client;

    private static ArrayList<Client> clientList;
       /*      static ArrayList<Vehicle> vehicleList;
        static ArrayList<Department> departmentsList;
        static Client client = new Client();


        public ClientView(ArrayList<Client> clientList,ArrayList<Department> departmentsList,ArrayList<Vehicle> vehicleList) {
            this.clientList = clientList;
            this.vehicleList = vehicleList;
            this.departmentsList = departmentsList;
        }
    */
    public ClientView(Client client) {
        this.client = client;
        tabbedPane1.addComponentListener(new ComponentAdapter() {
        });
        reservePanel.addComponentListener(new ComponentAdapter() {
        });
        myDataPanel.addComponentListener(new ComponentAdapter() {
        });
        peselLabel.addComponentListener(new ComponentAdapter() {
        });
        IDLabel.setText("ID: " + client.getID());
        firstNameLabel.setText("Imię: "+ client.getFirstName());
        lastNameLabel.setText("Nazwisko: " + client.getLastName());
        peselLabel.setText("PESEL: "+ client.getPESEL());

        modifyDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
