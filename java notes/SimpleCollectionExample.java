import java.util.ArrayList; // Import the ArrayList class
import java.util.List;    // Import the List interface

public class SimpleCollectionExample {
    public static void main(String[] args) {
        // Create a List of Strings using ArrayList
        List<String> fruits = new ArrayList<>();

        // Add elements to the list
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");

        // Print the entire list
        System.out.println("Fruits in the list: " + fruits);

        // Access elements by index
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Third fruit: " + fruits.get(2));

        // Iterate through the list using an enhanced for-loop
        System.out.println("\nIterating through fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        // Remove an element
        fruits.remove("Orange");
        System.out.println("\nFruits after removing Orange: " + fruits);

        // Check if an element exists
        boolean hasBanana = fruits.contains("Banana");
        System.out.println("Does the list contain Banana? " + hasBanana);

        // Get the size of the list
        System.out.println("Number of fruits in the list: " + fruits.size());
    }
}