package data;

import java.util.ArrayList;

public class Department {

    private int departmentID;
    private String city;
    private String address;
    private ArrayList<Vehicle> vehicles;

    public Department(int departmentID, String city, String address) {
        this.departmentID = departmentID;
        this.city = city;
        this.address = address;
        vehicles = new ArrayList<Vehicle>();
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
