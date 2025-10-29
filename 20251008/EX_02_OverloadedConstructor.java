public class EX_02_OverloadedConstructor {

    // Instance variables (fields) of the class
    private String name;
    private double mass; // in Earth masses
    private int moons;
    
    // --- Constructor 1: No arguments (Default Constructor) ---
    // Initializes the object with default, empty, or zero values.
    public EX_02_OverloadedConstructor() {
        this.name = "Unknown Planet";
        this.mass = 0.0;
        this.moons = 0;
        System.out.println("-> Default planet created.");
    }

    // --- Constructor 2: One argument (name only) ---
    // Allows creating a planet by just providing its name.
    public EX_02_OverloadedConstructor(String name) {
        // 'this(name, 1.0, 0)' is an example of constructor chaining.
        // It calls Constructor 3 to reuse its initialization logic.
        this(name, 1.0, 0); 
        System.out.println("-> Planet created with name only.");
    }
    
    // --- Constructor 3: Two arguments (name and mass) ---
    // Allows creating a planet with its name and mass, defaulting moons to 0.
    public EX_02_OverloadedConstructor(String name, double mass) {
        this(name, mass, 0); // Constructor chaining to the full constructor
        System.out.println("-> Planet created with name and mass.");
    }

    // --- Constructor 4: Three arguments (name, mass, and moons) ---
    // The "full" or main constructor. It is often the target for chaining.
    public EX_02_OverloadedConstructor(String name, double mass, int moons) {
        this.name = name;
        this.mass = mass;
        this.moons = moons;
        System.out.println("-> Planet fully initialized.");
    }

    // --- Other Methods ---

    // A simple method to display the planet's information
    public void displayInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Mass (Earths): " + mass);
        System.out.println("Moons: " + moons);
    }
    
    // Overriding the toString() method for easy printing with System.out.println()
    @Override
    public String toString() {
        return "PlanetInfo[name=" + name + ", mass=" + mass + ", moons=" + moons + "]";
    }

    // --- Main Method (Demonstration) ---

    public static void main(String[] args) {
        System.out.println("--- Demonstrating Overloaded Constructors ---");

        // 1. Calls Constructor 4 (String, double, int)
        EX_02_OverloadedConstructor earth = new EX_02_OverloadedConstructor("Earth", 1.0, 1);
        earth.displayInfo();
        
        // 2. Calls Constructor 3 (String, double)
        EX_02_OverloadedConstructor mars = new EX_02_OverloadedConstructor("Mars", 0.107, 2);
        mars.displayInfo();
        
        // 3. Calls Constructor 2 (String)
        EX_02_OverloadedConstructor unknownMoon = new EX_02_OverloadedConstructor("Moon X");
        unknownMoon.displayInfo();
        
        // 4. Calls Constructor 1 (No arguments)
        EX_02_OverloadedConstructor defaultPlanet = new EX_02_OverloadedConstructor();
        defaultPlanet.displayInfo();
        
        System.out.println("\n--- Printing Objects using the overridden toString() ---");
        System.out.println("Mars Object: " + mars);
        System.out.println("Earth Object: " + earth);
    }
}