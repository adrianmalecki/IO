package data;

import java.time.LocalDate;
import java.util.List;

public class Reservation {

    private int reservationID;
    private Client client;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Vehicle> cars;

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }
}
