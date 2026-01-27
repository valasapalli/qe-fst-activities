package deepthi;

public class Activity3 {
    public static void main(String[] args) {
        double seconds = 1000000000;
        double EarthSeconds = 31557600;

        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447495;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        System.out.println("Age on Earth: " + seconds / EarthSeconds);
        System.out.println("Age on Mercury:"+seconds/(MercurySeconds * EarthSeconds));
        System.out.println("Age on Venus:"+seconds/(VenusSeconds * EarthSeconds));
        System.out.println("Age on Mars:"+seconds/(MarsSeconds*EarthSeconds));
        System.out.println("Age on Jupiter:"+seconds/(JupiterSeconds*EarthSeconds));
        System.out.println("Age on Saturn:"+seconds/(SaturnSeconds*EarthSeconds));
        System.out.println("Age on Uranus:"+seconds/(UranusSeconds*EarthSeconds));
        System.out.println("Age on Neptune:"+seconds/(NeptuneSeconds*EarthSeconds));
    }

}
