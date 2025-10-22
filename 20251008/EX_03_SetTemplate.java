import java.util.HashSet;
import java.util.Set;

public class EX_03_SetTemplate {

    public static void main(String[] args) {
        // 1. Declare and initialize a Set using the HashSet implementation.
        // HashSet is the most common choice for fast operations (O(1) average time).
        Set<String> uniqueColors = new HashSet<>();

        // 2. Add elements
        System.out.println("--- 1. Adding unique, individual elements ---");
        uniqueColors.add("Red");
        uniqueColors.add("Blue");
        uniqueColors.add("Green");
        uniqueColors.add("Yellow");
        
        System.out.println("Set after initial adds: " + uniqueColors);

        // 3. Attempt to add a duplicate element
        boolean wasAdded = uniqueColors.add("Red"); // This element already exists
        
        System.out.println("\n--- 2. Handling Duplicates ---");
        System.out.println("Attempted to add 'Red' again. Was it added? " + wasAdded);
        System.out.println("Set size remains the same: " + uniqueColors.size());
        
        // 4. Check for the presence of an element
        System.out.println("\n--- 3. Checking Presence ---");
        boolean containsBlue = uniqueColors.contains("Blue");
        System.out.println("Does the Set contain 'Blue'? " + containsBlue);
        
        // 5. Remove an element
        System.out.println("\n--- 4. Removing Elements ---");
        uniqueColors.remove("Yellow");
        System.out.println("Set after removing 'Yellow': " + uniqueColors);

        // 6. Iterate through the Set (Note: Order is not guaranteed in HashSet)
        System.out.println("\n--- 5. Iterating (Order not guaranteed in HashSet) ---");
        for (String color : uniqueColors) {
            System.out.println("Color: " + color);
        }
    }
}