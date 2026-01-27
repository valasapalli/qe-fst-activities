package deepthi;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("ferraro");
        hs.add("Snickers");
        hs.add("Bournville");
        hs.add("DairyMilk");
        hs.add("Kitkat");   
        
        System.out.println("Size of Hashset: " + hs.size());

        hs.remove("DairyMilk");

        boolean removed = hs.remove("watermelon");
        System.out.println("Trying to remove 'Watermelon': " + removed);

        System.out.println("Contains ferraro? " + hs);
        System.out.println("Updated Hashset: " + hs);
    }

    

}
