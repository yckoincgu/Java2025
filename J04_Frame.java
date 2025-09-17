import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Corrected class definition:
// J04_Frame now extends (inherits from) Frame
class J04_Frame extends Frame {

    J04_Frame() {
        setTitle("Hello AWT");
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString("Hello, AWT!", 100, 100);
    }
}