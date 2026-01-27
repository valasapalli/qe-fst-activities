package deepthi;
import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "Red");
        colours.put(2, "Yellow");
        colours.put(3, "Green");
        colours.put(4, "Orange");
        colours.put(5, "Pink");

        System.out.println("colours map:" + colours);
        colours.remove(4);

        System.out.println("Contains Green?" +colours.containsValue("Green"));
        System.out.println("Size of the map:" + colours.size());

        
    }

}
