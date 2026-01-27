package deepthi;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Plane {

    // private variables
    private int maxPassengers;
    private ArrayList<String> passengers;
    private LocalDateTime lastTimeLanded;

    // constructor
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    // onboard method
    public void onboard(String passengerName) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passengerName);
        } else {
            System.out.println("Plane is full. Cannot add: " + passengerName);
        }
    }

    // takeOff method
    public LocalDateTime takeOff() {
        return LocalDateTime.now();
    }

    // land method
    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passengers.clear();
    }

    // getter for lastTimeLanded
    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    // getter for passengers
    public ArrayList<String> getPassengers() {
        return passengers;
    }
}
