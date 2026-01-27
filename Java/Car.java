package deepthi;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car(){
        tyres = 4;
        doors = 4;
    }
    void displayCharacteristics() {
        System.out.println("Car make: " + make);
        System.out.println("Car color: " + color);
        System.out.println("Car transmission " + transmission);
        System.out.println("Car tyres: " + tyres);
        System.out.println("Car doors: " + doors);
    }

    void accelerate() {
        System.out.println("Car is moving forward");
    }

    void brake() {
        System.out.println("Car has stopped");
    }

}
