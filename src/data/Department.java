package data;

public class Department {

    private int departmentID;
    private String city;
    private String address;

    public Department(int departmentID, String city, String address) {
        this.departmentID = departmentID;
        this.city = city;
        this.address = address;
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
}
