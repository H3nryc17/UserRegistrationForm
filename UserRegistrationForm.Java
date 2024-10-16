import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationForm extends JFrame {

    private JTextField nameField, emailField, passwordField, confirmPasswordField;
    private JButton submitButton, clearButton;

    public UserRegistrationForm() {
        
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));  

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(submitButton);
        add(clearButton);

        submitButton.addActionListener(new SubmitButtonListener());
        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
        
                JOptionPane.showMessageDialog(null, 
                        "Name: " + name + "\nEmail: " + email + "\nRegistration Successful!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields(); 
            }
        }
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}
