package Programs;
import java.awt.event.*;
import javax.swing.*;

public class KeyEventsDemo extends JFrame implements KeyListener {
    private JTextArea textArea;

    public KeyEventsDemo() {
        super("Key Events Demo");
        textArea = new JTextArea();
        textArea.addKeyListener(this);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void keyTyped(KeyEvent e) {
        displayInfo(e, "Key Typed");
    }

    public void keyPressed(KeyEvent e) {
        displayInfo(e, "Key Pressed");
    }

    public void keyReleased(KeyEvent e) {
        displayInfo(e, "Key Released");
    }

    private void displayInfo(KeyEvent e, String eventType) {
        int id = e.getID();
        String keyString = KeyEvent.getKeyText(e.getKeyCode());
        String message = eventType + ": " + keyString + " (key code: " + e.getKeyCode() + ")";
        if (id == KeyEvent.KEY_TYPED) {
            textArea.append(message + "\n");
        } else {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        new KeyEventsDemo();
    }
}