package deepthi;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Deekshitha");
        myList.add("Bhavana");
        myList.add("Harshlika");
        myList.add("sreehasa");
        myList.add("Lasya");

        System.out.println("Names in the List: ");
        for( int i= 0; i < myList.size();i++){
            System.out.println(myList.get(i));
        }

        System.out.println("\n3rd name in the list:");
        System.out.println(myList.get(2));

        System.out.println("\nCheck if 'Harshlika' exsists");
        System.out.println(myList.contains("Harshlika"));

        System.out.println("\nsize of the List:");
        System.out.println(myList.size());

        myList.remove("Lasya");

        System.out.println("\nSize after removing a name:");
        System.out.println(myList.size());

    }


}
