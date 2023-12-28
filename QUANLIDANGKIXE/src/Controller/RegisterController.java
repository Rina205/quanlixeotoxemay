package Controller;

import javax.swing.JOptionPane;

import Model.UserModel;

public class RegisterController {
	private UserModel userModel;

    public void RegisterController(UserModel userModel) {
        this.userModel = userModel;
    }

    public void register(String username, String password) {
        // Perform registration logic here
        userModel = new UserModel(username, password);
        JOptionPane.showMessageDialog(null, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}