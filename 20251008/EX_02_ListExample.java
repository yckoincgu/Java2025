import java.util.ArrayList; // ArrayList is a class implementing the List interface
import java.util.List;      // List is an interface, 
                            // separating declaration from implementation

public class EX_02_ListExample {

    public static void main(String[] args) {
        /* An ordered collection (sequence). 
         * Elements can be accessed by their integer index (position). 
         * Allows duplicate elements.
         */ 
        // 1. Declare and initialize a List using the ArrayList implementation
        // Declare the variable as the interface (List)
        // and instantiate the concrete class (ArrayList).
        List<String> planets = new ArrayList<>();

        // 2. Add elements (maintains insertion order)
        System.out.println("--- 1. Adding Elements ---");
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Earth"); // List allows duplicates

        System.out.println("Initial List: " + planets);
        System.out.println("List Size: " + planets.size());

        // 3. Access elements by index (0-based)
        System.out.println("\n--- 2. Accessing Elements ---");
        String thirdPlanet = planets.get(2);
        System.out.println("The third planet is: " + thirdPlanet);

        // 4. Modify and Insert elements
        System.out.println("\n--- 3. Modifying and Inserting ---");
        // Replace the element at index 4 (Jupiter)
        planets.set(4, "Saturn");
        // Insert an element at a specific index (shifts all subsequent elements)
        planets.add(3, "New Jupiter");

        System.out.println("List after modification: " + planets);

        // 5. Remove elements
        System.out.println("\n--- 4. Removing Elements ---");
        // Remove by index (removes the first "Earth" at index 2)
        planets.remove(2);

        // Remove by value (removes the *first* occurrence of "Earth")
        planets.remove("Earth");

        System.out.println("List after removal: " + planets);
        
        // 6. Iterate through the List using a For-Each loop
        System.out.println("\n--- 5. Iterating ---");
        int i=0;
        for (String planet : planets) {
            System.out.println("Planet "+(i++)+" : " + planet);
        }
    }
}