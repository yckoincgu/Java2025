public class J05_App {
    String name;
    int model;

    public J05_App(String name, int model) {
        this.name = name;
        this.model = model;
    }

    public String getGreeting() {
        return "Welcome to " + name + " model " + model + "!";
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Model: " + model);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        J05_App app1 = new J05_App("iPhone", 14);
        J05_App app2 = new J05_App("Samsung Galaxy", 7);
        J05_App app3 = new J05_App("Pixel", 9);

        System.out.println("=== Displaying Information of 3 Instances ===");
        app1.displayInfo();
        app2.displayInfo();
        app3.displayInfo();

        System.out.println("=== Greetings ===");
        System.out.println(app1.getGreeting());
        System.out.println(app2.getGreeting());
        System.out.println(app3.getGreeting());
    }
}
