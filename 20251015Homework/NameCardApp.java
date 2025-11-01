import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NameCardApp {

    private static final String NAME   = "Dennis Chen";
    private static final String TITLE  = "Data Science & Business Administration";
    private static final String EMAIL  = "dennis07250725@gmail.com";
    private static final String PHONE  = "+886 939 570 070";
    private static final String SITE   = "https://github.com/dennis20413";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NameCardApp::showCard);
    }

    private static void showCard() {
        JFrame frame = new JFrame("My Name Card");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true));

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(18, 22, 18, 22));

        JPanel header = new JPanel(new GridLayout(2, 1, 0, 2));
        header.setOpaque(false);

        JLabel nameLbl = new JLabel(NAME);
        nameLbl.setFont(nameLbl.getFont().deriveFont(Font.BOLD, 20f));
        nameLbl.setForeground(new Color(30, 30, 30));

        JLabel titleLbl = new JLabel(TITLE);
        titleLbl.setFont(titleLbl.getFont().deriveFont(Font.PLAIN, 13f));
        titleLbl.setForeground(new Color(90, 90, 90));

        header.add(nameLbl);
        header.add(titleLbl);

        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(230, 230, 230));

        JPanel info = new JPanel(new GridLayout(3, 1, 0, 6));
        info.setOpaque(false);

        info.add(makeRow("Email", EMAIL, true));
        info.add(makeRow("Phone", PHONE, false));
        info.add(makeRow("Website", SITE, true));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        footer.setOpaque(false);

        JButton copyBtn = new JButton("Copy Email");
        copyBtn.addActionListener(e -> {
            Toolkit.getDefaultToolkit().getSystemClipboard()
                   .setContents(new java.awt.datatransfer.StringSelection(EMAIL), null);
            toast(frame, "Email copied!");
        });

        JButton okBtn = new JButton("Close");
        okBtn.addActionListener(e -> frame.dispose());

        footer.add(copyBtn);
        footer.add(okBtn);

        card.add(header, BorderLayout.NORTH);
        card.add(sep, BorderLayout.CENTER);
        card.add(info, BorderLayout.SOUTH);

        JPanel outer = new JPanel(new BorderLayout(0, 12));
        outer.setBackground(Color.WHITE);
        outer.setBorder(new EmptyBorder(10, 10, 10, 10));
        outer.add(card, BorderLayout.CENTER);
        outer.add(footer, BorderLayout.SOUTH);

        frame.setContentPane(outer);
        frame.pack();
        frame.setSize(new Dimension(380, 220));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        enableDrag(frame, outer);
    }

    private static JPanel makeRow(String label, String value, boolean linkStyle) {
        JPanel row = new JPanel(new BorderLayout());
        row.setOpaque(false);

        JLabel key = new JLabel(label);
        key.setFont(key.getFont().deriveFont(Font.BOLD, 12f));
        key.setForeground(new Color(70, 70, 70));

        JLabel val = new JLabel(value);
        val.setFont(val.getFont().deriveFont(Font.PLAIN, 12f));
        val.setForeground(linkStyle ? new Color(33, 114, 229) : new Color(60, 60, 60));
        if (linkStyle) {
            val.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            val.addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new java.net.URI(toHttpUrl(value)));
                    } catch (Exception ex) {
                        Toolkit.getDefaultToolkit().getSystemClipboard()
                               .setContents(new java.awt.datatransfer.StringSelection(value), null);
                        Component c = SwingUtilities.getWindowAncestor(row);
                        if (c instanceof JFrame f) toast(f, "Link copied to clipboard");
                    }
                }
            });
        }

        row.add(key, BorderLayout.WEST);
        row.add(val, BorderLayout.CENTER);
        return row;
    }

    private static String toHttpUrl(String s) {
        String v = s.trim();
        if (v.startsWith("http://") || v.startsWith("https://")) return v;
        return "https://" + v;
    }

    private static void toast(JFrame owner, String msg) {
        JDialog d = new JDialog(owner, false);
        d.setUndecorated(true);
        JLabel l = new JLabel("  " + msg + "  ");
        l.setOpaque(true);
        l.setBackground(new Color(40, 40, 40, 220));
        l.setForeground(Color.WHITE);
        l.setBorder(new EmptyBorder(6, 10, 6, 10));
        d.getContentPane().add(l);
        d.pack();
        Point p = owner.getLocationOnScreen();
        d.setLocation(p.x + owner.getWidth() - d.getWidth() - 16, p.y + owner.getHeight() - d.getHeight() - 16);
        new javax.swing.Timer(1400, e -> d.dispose()).start();
        d.setVisible(true);
    }

    private static void enableDrag(JFrame frame, JComponent dragArea) {
        final Point[] start = {null};
        dragArea.addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) { start[0] = e.getPoint(); }
        });
        dragArea.addMouseMotionListener(new MouseAdapter() {
            @Override public void mouseDragged(MouseEvent e) {
                if (start[0] != null) {
                    Point p = e.getLocationOnScreen();
                    frame.setLocation(p.x - start[0].x, p.y - start[0].y);
                }
            }
        });
    }
}
