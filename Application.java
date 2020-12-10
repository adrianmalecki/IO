package application;

import data.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ArrayList<Client> clientList = new ArrayList<Client>();
        ArrayList<Worker> workersList;
        ArrayList<Rental> rentalList;
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        ArrayList<Department> departmentsList = new ArrayList<Department>();
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        ArrayList<Bill> billList;
        Client client1 = new Client(1,991236781,"Jan","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","ghtyhrtg",123,1,"333","q","q");
        clientList.add(client1);
        Client client2 = new Client(2,123236781,"John","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","w54hw54h",456,2,"444","login2","password2");
        clientList.add(client2);
        Client client3 = new Client(3,786789781,"Tomasz","Kot", "432134567", "tdh@o2.pl", "1234-45", "Warszawa","64wu4wht",789,3,"555","login3","password3");
        clientList.add(client3);

        Department department1 = new Department(1,"Wrocław", "oiwrngf");
        departmentsList.add(department1);

        Vehicle vehicle1 = new Vehicle(1,"Fiat","126p", 1970,12345,department1);
        vehicleList.add(vehicle1);
        Vehicle vehicle2 = new Vehicle(2,"Ford","Mondeo", 1970,12345,department1);
        vehicleList.add(vehicle2);
        Vehicle vehicle3 = new Vehicle(3,"Ford","GT", 1970,12345,department1);
        vehicleList.add(vehicle3);
        Vehicle vehicle4 = new Vehicle(4,"Fiat","Sejczento", 1970,12345,department1);
        vehicleList.add(vehicle4);

        //ClientView clientView = new ClientView(clientList, departmentsList, vehicleList);

        for (Client c:clientList) {
            System.out.println(c.getLogin());
        }
        SignInPanel signInPanel = new SignInPanel(clientList, departmentsList);
        signInPanel.runSignInPanel();

    }
}
