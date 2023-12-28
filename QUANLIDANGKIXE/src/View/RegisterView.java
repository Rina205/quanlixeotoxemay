package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.RegisterController;

public class RegisterView extends JFrame{
	 private JLabel usernameLabel;
	    private JLabel passwordLabel;
	    private JTextField usernameField;
	    private JPasswordField passwordField;
	    private JButton registerButton;

	    private RegisterController registercontroller;

	    public RegisterView(RegisterController registerController) {
	        this.registercontroller = registerController;

	        setTitle("Register");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(300, 150);
	        setLayout(new GridLayout(3, 2));

	        usernameLabel = new JLabel("Username:");
	        passwordLabel = new JLabel("Password:");
	        usernameField = new JTextField();
	        passwordField = new JPasswordField();
	        registerButton = new JButton("Register");

	        registerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = new String(passwordField.getPassword());
	                registerController.register(username, password);
	            }
	        });

	        this.add(usernameLabel);
	        this.add(usernameField);
	        this.add(passwordLabel);
	        this.add(passwordField);
	        this.add(registerButton);

	        setVisible(true);
	    }

	    public void showSuccessMessage() {
	        JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    
	    
	    
}