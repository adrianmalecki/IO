package data;

public class Vehicle {

    private int vehicleID;
    private String brand;
    private String model;
    private int yearOfProduction;
    private int carsMileage;
    private enum status{};
    private enum stateOfCar{};
    private Department department;

    public Vehicle(int vehicleID, String brand, String model, int yearOfProduction, int carsMileage, Department department) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.carsMileage = carsMileage;
        this.department = department;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getCarsMileage() {
        return carsMileage;
    }

    public void setCarsMileage(int carsMileage) {
        this.carsMileage = carsMileage;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
