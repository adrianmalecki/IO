package data;

public class Vehicle {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int carsMileage;
    private Status status;
    private StateOfCar stateOfCar;

    public Vehicle(String brand, String model, int yearOfProduction, int carsMileage, Status status, StateOfCar stateOfCar) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.carsMileage = carsMileage;
        this.status = status;
        this.stateOfCar = stateOfCar;
    }

    public static void modifyData() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StateOfCar getStateOfCar() {
        return stateOfCar;
    }

    public void setStateOfCar(StateOfCar stateOfCar) {
        this.stateOfCar = stateOfCar;
    }
}
