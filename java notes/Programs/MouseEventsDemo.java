package Programs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventsDemo extends JFrame implements MouseListener, MouseMotionListener {
    private JLabel statusBar;

    public MouseEventsDemo() {
        super("Mouse Events Demo");
        statusBar = new JLabel();
        statusBar.setHorizontalAlignment(SwingConstants.CENTER);
        addMouseListener(this);
        addMouseMotionListener(this);
        add(statusBar, BorderLayout.SOUTH);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        statusBar.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {
        statusBar.setText("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseReleased(MouseEvent e) {
        statusBar.setText("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseEntered(MouseEvent e) {
        statusBar.setText("Mouse entered at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseExited(MouseEvent e) {
        statusBar.setText("Mouse exited at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseDragged(MouseEvent e) {
        statusBar.setText("Mouse dragged at (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mouseMoved(MouseEvent e) {
        statusBar.setText("Mouse moved at (" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}