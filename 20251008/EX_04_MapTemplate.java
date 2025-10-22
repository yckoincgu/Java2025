import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EX_04_MapTemplate {

    public static void main(String[] args) {
        // 1. Declare and initialize a Map using the HashMap implementation.
        // The Map stores String keys (Car Model) and Integer values (Year).
        Map<String, Integer> carModelYears = new HashMap<>();

        // 2. Add key-value pairs using the put() method
        System.out.println("--- 1. Adding Elements (unique key-value pairs) ---");
        carModelYears.put("Civic", 2024);
        carModelYears.put("Model 3", 2023);
        carModelYears.put("Camry", 2025);
        carModelYears.put("F-150", 2022);

        System.out.println("Initial Map: " + carModelYears);

        // 3. Attempt to add a duplicate key (Updates the value)
        // Since "Civic" already exists, its value is updated from 2024 to 2020.
        carModelYears.put("Civic", 2020); 

        System.out.println("\n--- 2. Handling Duplicate Keys by put() ---");
        System.out.println("Map after updating 'Civic': " + carModelYears);

        // 4. Retrieve a value using its key
        System.out.println("\n--- 3. Retrieving Values ---");
        int camryYear = carModelYears.get("Camry");
        System.out.println("Year of Camry by get(): " + camryYear);

        // Check if a key exists
        boolean hasModel3 = carModelYears.containsKey("Model 3");
        System.out.println("Does the map contain 'Model 3' by containskey()? " + hasModel3);

        // 5. Remove a key-value pair
        System.out.println("\n--- 4. Removing Elements by remove()---");
        carModelYears.remove("F-150");
        System.out.println("Map after removing 'F-150': " + carModelYears);

        // 6. Iterate through the Map (using the key set)
        System.out.println("\n--- 5. Iterating Keys, i.e. model, to get its year ---");
        
        // Get all keys from the map
        Set<String> models = carModelYears.keySet(); 

        for (String model : models) {
            int year = carModelYears.get(model);
            System.out.println("Model: " + model + " -> Year: " + year);
        }
    }
}