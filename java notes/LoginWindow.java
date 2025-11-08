import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginWindow() {
        super("Login Window");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(new JLabel());
        add(loginButton);
        loginButton.addActionListener(this);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            if (!username.isEmpty() && passwordChars.length > 0) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}