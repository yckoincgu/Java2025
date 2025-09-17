import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// A new class that extends Frame to handle painting
class HelloFrame extends Frame {

    public HelloFrame(String title) {
        super(title);
        setSize(400, 400);

        // Add a window listener to close the application
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // This method is automatically called by the AWT system to paint the frame.
    public void paint(Graphics g) {
        g.drawString("Hello, AWT!", 150, 150);
    }
}

// The main application class to start the program
public class J02_HelloApp {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Running on JDK " + Runtime.version());
        int number = 42;
        System.out.println("Hello, World! The answer is " + number);

        HelloFrame frame = new HelloFrame("Hello, AWT!");
        frame.setVisible(true);
    }
}