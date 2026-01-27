package deepthi;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {

        // create Plane object
        Plane plane = new Plane(10);

        // onboard passengers
        plane.onboard("Alice");
        plane.onboard("Bob");
        plane.onboard("Charlie");
        plane.onboard("Diana");

        // print take-off time
        System.out.println("Take-off time: " + plane.takeOff());

        // print passengers list
        System.out.println("Passengers on board: " + plane.getPassengers());

        // pause for 5 seconds (simulate flight)
        Thread.sleep(5000);

        // land the plane
        plane.land();

        // print landing time
        System.out.println("Landing time: " + plane.getLastTimeLanded());

        // verify passengers cleared
        System.out.println("Passengers after landing: " + plane.getPassengers());
    }
}



