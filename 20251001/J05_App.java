/*
    Clean Build via VS Code Commands 
    Windows/Linux: Ctrl+Shift+P
    Type "java clean", select "Java: Clean the Java language server workspace" 
*/

public class J05_App {
    
    public static void main(String[] args) {
        
        // Create two Person objects
        Cellphone app1 = new Cellphone("iPhone", "12 Pro", 999.99);
        Cellphone app2 = new Cellphone("samsung", "Galax", 899.99);
        SmartWatch app3 = new SmartWatch("samsung", "Galax", 599.99, true);

        // Call object methods
        System.out.println();
        System.out.println(app1.toString());
        System.out.println();
        System.out.println(app2.toString());
        System.out.println();
        System.out.println(app3.toString());
    }

}