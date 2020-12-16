package application;

import data.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Facade {
    private ArrayList<Client> clientList;
    private ArrayList<Worker> workersList;
    private ArrayList<Department> departmentsList;
    private ArrayList<Rental> rentalList;
    private ArrayList<Reservation> reservationList;
    private ArrayList<Bill> billList;

    public Facade() {
        clientList = new ArrayList<Client>();
        workersList = new ArrayList<Worker>();
        departmentsList = new ArrayList<Department>();
        rentalList = new ArrayList<Rental>();
        reservationList = new ArrayList<Reservation>();
        billList = new ArrayList<Bill>();
    }

    public static void main(String[] args) {

        Facade app = new Facade();

        Client client1 = new Client(1,991236781,"Jan","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","ghtyhrtg",123,1,"333","q","q");
        app.addClient(client1);
        Client client2 = new Client(2,123236781,"John","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","w54hw54h",456,2,"444","login2","password2");
        app.addClient(client2);
        Client client3 = new Client(3,786789781,"Tomasz","Kot", "432134567", "tdh@o2.pl", "1234-45", "Warszawa","64wu4wht",789,3,"555","login3","password3");
        app.addClient(client3);

        Department department1 = new Department(1,"Wrocław", "Plac Grunwaldzki 1");
        app.addDepartment(department1);

        Vehicle vehicle1 = new Vehicle(1,"Volkswagen","Polo", 2018,12345);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle1);
        Vehicle vehicle2 = new Vehicle(2,"Ford","Mondeo", 2017,12345);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle2);
        Vehicle vehicle3 = new Vehicle(3,"Lamborghini","Aventador", 2019,12345);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle3);
        Vehicle vehicle4 = new Vehicle(4,"Fiat","Seicento", 2004,12345);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle4);



        //ClientView clientView = new ClientView(clientList, departmentsList, vehicleList);

        for (Client c: app.getClientList()) {
            System.out.println(c.getLogin());
        }
        SignInPanel signInPanel = new SignInPanel(app.getClientList(), app.getDepartmentsList());
        signInPanel.runSignInPanel();

    }

    private void addClient(Client client) {
        getClientList().add(client);
    }

    private void addDepartment(Department department) {
        getDepartmentsList().add(department);
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public ArrayList<Worker> getWorkersList() {
        return workersList;
    }

    public void setWorkersList(ArrayList<Worker> workersList) {
        this.workersList = workersList;
    }

    public ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(ArrayList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public ArrayList<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(ArrayList<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(ArrayList<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public ArrayList<Bill> getBillList() {
        return billList;
    }

    public void setBillList(ArrayList<Bill> billList) {
        this.billList = billList;
    }
}
