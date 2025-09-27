// Create a class to contain the main method
public class J03_HelloApp {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Running on JDK " + Runtime.version());
        int number = 42;
        System.out.println("Hello, World! The answer is " + number);

        J04_Frame frame = null;
        try {
            frame = new J04_Frame(); }
        catch (Exception e) {   e.printStackTrace();  }
            
        frame.setVisible(true); // Throws a NullPointerException
        }
}

