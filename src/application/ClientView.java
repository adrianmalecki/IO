package application;

import java.awt.event.ComponentAdapter;

import javax.swing.*;

public class ClientView {
    public JPanel clientPanel;
    private JTabbedPane tabbedPane;
    static JFrame frame = new JFrame("Wypożyczalnia pojazdów");

    /*    private static ArrayList<Client> clientList;
        static ArrayList<Vehicle> vehicleList;
        static ArrayList<Department> departmentsList;
        static Client client = new Client();


        public ClientView(ArrayList<Client> clientList,ArrayList<Department> departmentsList,ArrayList<Vehicle> vehicleList) {
            this.clientList = clientList;
            this.vehicleList = vehicleList;
            this.departmentsList = departmentsList;
        }
    */
    public ClientView() {
        tabbedPane = new JTabbedPane();

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
        // TODO: place custom component creation code here
    }
}
