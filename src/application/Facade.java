package application;

import data.*;

import java.util.ArrayList;

public class Facade {
    private static ArrayList<Client> clientList;
    private static ArrayList<Worker> workersList;
    private static ArrayList<Department> departmentsList;
    private static ArrayList<Rental> rentalList;
    private static ArrayList<Reservation> reservationList;
    private static ArrayList<Bill> billList;

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

        Client client1 = new Client("99010112147","Jan","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","ghtyhrtg","ABC123456","333","q","q");
        app.addClient(client1);
        Client client2 = new Client("77122587963","John","Nowak", "123456789", "asdf@o2.pl", "1234-45", "Wroclaw","w54hw54h","CBA456789","444","login2","password2");
        app.addClient(client2);
        Client client3 = new Client("88071945789","Tomasz","Kot", "432134567", "tdh@o2.pl", "1234-45", "Warszawa","64wu4wht","BSF147852","555","login3","password3");
        app.addClient(client3);

        Department department1 = new Department("Wrocław", "Plac Grunwaldzki 1");
        app.addDepartment(department1);

        Vehicle vehicle1 = new Vehicle("Volkswagen","Polo", 2018,12345, Status.AVAILABLE, StateOfCar.FUNCTIONAL);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle1);
        Vehicle vehicle2 = new Vehicle("Ford","Mondeo", 2017,12345, Status.AVAILABLE, StateOfCar.FUNCTIONAL);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle2);
        Vehicle vehicle3 = new Vehicle("Lamborghini","Aventador", 2019,12345, Status.AVAILABLE, StateOfCar.DAMAGED);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle3);
        Vehicle vehicle4 = new Vehicle("Fiat","Seicento", 2004,12345, Status.AVAILABLE, StateOfCar.SERVICE_REQUIRED);
        app.getDepartmentsList().get(0).getVehicles().add(vehicle4);


        for (Client c: getClientList()) {
            System.out.println(c.getLogin());
        }
        SignInPanel signInPanel = new SignInPanel();
        signInPanel.runSignInPanel();

    }

    public static int verifyData(String login, String password){
        for (Client c: clientList) {
            if(login.equals(c.getLogin())) {
                if (password.equals(c.getPassword())) {
                    return clientList.indexOf(c);
                }
            }
        }
        return -1;
    }

    public static boolean checkPESEL(String PESEL) {
        for (Client c:clientList) {
            if(PESEL.equals(c.getPESEL())) {
                return true;
            }
        }
        return false;
    }

    public static void modifyData(Client client, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address) {
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);
        client.setCity(city);
        client.setPostCode(postCode);
    }

    public static void registerClient(String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber, String drivingLicenseNumber, String login, char[] password) {
        Client client = new Client(PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber, drivingLicenseNumber, login, String.valueOf(password));
        addClient(client);
    }

    private static void addClient(Client client) {
        clientList.add(client);
    }

    private static void addDepartment(Department department) {
        getDepartmentsList().add(department);
    }

    public static ArrayList<Client> getClientList() {
        return clientList;
    }

    public static void setClientList(ArrayList<Client> clientList) {
        Facade.clientList = clientList;
    }

    public static ArrayList<Worker> getWorkersList() {
        return workersList;
    }

    public static void setWorkersList(ArrayList<Worker> workersList) {
        Facade.workersList = workersList;
    }

    public static ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    public static void setDepartmentsList(ArrayList<Department> departmentsList) {
        Facade.departmentsList = departmentsList;
    }

    public static ArrayList<Rental> getRentalList() {
        return rentalList;
    }

    public static void setRentalList(ArrayList<Rental> rentalList) {
        Facade.rentalList = rentalList;
    }

    public static ArrayList<Reservation> getReservationList() {
        return reservationList;
    }

    public static void setReservationList(ArrayList<Reservation> reservationList) {
        Facade.reservationList = reservationList;
    }

    public static ArrayList<Bill> getBillList() {
        return billList;
    }

    public static void setBillList(ArrayList<Bill> billList) {
        Facade.billList = billList;
    }
}
