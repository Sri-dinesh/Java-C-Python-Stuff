// Freakinn Mouse Listerner & its Motion Listener and plenty of eventss !!

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Week11a extends JFrame implements MouseListener, MouseMotionListener {

    private JLabel statusbar;

    public Week11a() {
        super("Mouse Events Demoo Brooo");
        statusbar = new JLabel();

        statusbar.setHorizontalAlignment(SwingConstants.NORTH_EAST);

        addMouseListener(this);
        addMouseMotionListener(this);

        add(statusbar, BorderLayout.CENTER);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        statusbar.setText("Mouse clicked at " + e.getX() + ", " + e.getY());
    }

    public void mousePressed(MouseEvent e) {
        statusbar.setText("Mouse Pressed at " + e.getX() + ", " + e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        statusbar.setText("Mouse Dragged at " + e.getX() + ", " + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        statusbar.setText("Mouse Released at " + e.getX() + ", " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        statusbar.setText("Mouse Entered at " + e.getX() + ", " + e.getY());
    }

    public void mouseExited(MouseEvent e) {
        statusbar.setText("Mouse Exited at " + e.getX() + ", " + e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        statusbar.setText("Mouse Moved at " + e.getX() + ", " + e.getY());
    }

    public static void main(String[] args) {
        new Week11a();
    }
}