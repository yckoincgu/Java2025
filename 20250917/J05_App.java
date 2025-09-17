
public class J05_App {
    
    // Instance variables
    String name;
    int model;

    // Constructor
    J05_App(String name, int age) {
        this.name = name;
        this.model = age;
    }

    public String getGreeting() {
        return "Hello World!";
    }


    // Method to display information about the person
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + model);
    }   

    public static void main(String[] args) {
        
        // Create two Person objects
        J05_App app1 = new J05_App("iPhone", 14);
        J05_App app2 = new J05_App("SamSung Galaxy", 7);

        // Access and modify object properties
        app1.model = 5;

        // Call object methods
        app1.displayInfo();
        app2.displayInfo();
    }

}