package View;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.LoginController;

public class LoginView extends JFrame{

    private LoginController logincontroller;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton registerButton;

    public LoginView(LoginController logincontroller) {
        this.logincontroller = logincontroller;

        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3, 2));

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
         usernameField = new JTextField();
         passwordField = new JPasswordField();
        
         loginButton = new JButton("Login");
         registerButton = new JButton("Register");
         
         loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                logincontroller.login(username, password);
                
                TrangChuView nf = new TrangChuView();
                nf.setVisible(true);
                nf.setSize(1920,1080);
			}
			});

       

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logincontroller.showRegisterWindow();
            }
        });

        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
        this.add(registerButton);

        this.setVisible(true);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
