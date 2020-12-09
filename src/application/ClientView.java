package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Scanner;
import data.Client;
import data.Department;
import data.Reservation;
import data.Vehicle;
import org.mindrot.jbcrypt.BCrypt;


public class ClientView {
    private static ArrayList<Client> clientList;
    static ArrayList<Vehicle> vehicleList;
    static ArrayList<Department> departmentsList;
    static Client client = new Client();
    Scanner scanner = new Scanner(System.in);


    public ClientView(ArrayList<Client> clientList,ArrayList<Department> departmentsList,ArrayList<Vehicle> vehicleList) {
        this.clientList = clientList;
        this.vehicleList = vehicleList;
        this.departmentsList = departmentsList;
    }

    public void signIn() {

        System.out.print("Enter username: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String passwordd = scanner.nextLine();
        int cID = verifyData(login, passwordd);
        if(cID == -1){
            System.out.println("Niepoprawne dane logowania");
        }
        else{
            System.out.println(cID + " zalogowano");
        }

    }
    public int verifyData(String login, String password){
        for (Client c:clientList) {
            if(login.equals(c.getLogin())) {
                if (password.equals(c.getPassword())) {
                    return c.getClientID();
                }
            }
        }
        return -1;
    }




    public void register() {
        client.setUserID(4);
        client.setClientID(4);
        System.out.print("Enter PESEL: ");
        int pesel = Integer.parseInt(scanner.nextLine());
        client.setPESEL(pesel);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        client.setFirstName(name);


        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        client.setLastName(surname);

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        client.setPhoneNumber(phoneNumber);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        client.setEmail(email);

        System.out.print("Enter postcode: ");
        String postCode = scanner.nextLine();
        client.setPostCode(postCode);

        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        client.setCity(city);

        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        client.setAddress(address);

        System.out.print("Enter ID number: ");
        int identityCardNumber = Integer.parseInt(scanner.nextLine());
        client.setIdentityCardNumber(identityCardNumber);

        System.out.print("Enter driving license number: ");
        String drivingLicenseNr = scanner.nextLine();
        client.setDrivingLicenseNumber(drivingLicenseNr);

        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        client.setLogin(login);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        client.setPassword(password);

        clientList.add(client);
    }

    public void editData() {
    }

    public void deleteData() {
    }

    public void cancelReservation() {
    }

    public void showAvaiableCars(int departmentID){}

    public void reserveCar() {
        showDepartments();
        int choosen_department = chooseDepartment();
        System.out.print("Wybierz termin: ");
        String start_date = scanner.nextLine();
        String end_date = scanner.nextLine();
        showAvaiableCars(choosen_department);
        System.out.print("Wybierz pojazd: ");
        int carID = Integer.parseInt(scanner.nextLine());
        if(carID == 0){System.out.print("Rezerwacja anulowana: ");}
        else{
            System.out.print("Zarezerwowano pojazd: ");
            System.out.print(vehicleList.get(carID).getBrand());
            System.out.print(vehicleList.get(carID).getBrand());
            System.out.print(vehicleList.get(carID).getCarsMileage());
            System.out.print(vehicleList.get(carID).getYearOfProduction());
        }

    }

    public void showDepartments() {
        for (Department d:departmentsList) {
            System.out.print(d.getDepartmentID());
            System.out.print(d.getCity());
            System.out.print(d.getAddress());
        }
    }

    public int chooseDepartment() {
        System.out.print("Choose department: ");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public void showReservations() {
    }



}
