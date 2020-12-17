package data;

public class Worker extends User {

    private int workerID;
    private String workerPosition;
    private float salary;
    private Department department;

    public Worker(String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber, int workerID, String workerPosition, float salary, Department department) {
        super(PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber);
        this.workerID = workerID;
        this.workerPosition = workerPosition;
        this.salary = salary;
        this.department = department;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getWorkerPosition() {
        return workerPosition;
    }

    public void setWorkerPosition(String workerPosition) {
        this.workerPosition = workerPosition;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
