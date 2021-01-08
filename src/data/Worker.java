package data;

public class Worker extends User {

    private String workerPosition;
    private float salary;
    private Department department;

    public Worker(String login, String password, String PESEL, String firstName, String lastName, String phoneNumber, String email, String postCode, String city, String address, String identityCardNumber, String workerPosition, float salary, Department department) {
        super(login, password, PESEL, firstName, lastName, phoneNumber, email, postCode, city, address, identityCardNumber);
        this.workerPosition = workerPosition;
        this.salary = salary;
        this.department = department;
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
