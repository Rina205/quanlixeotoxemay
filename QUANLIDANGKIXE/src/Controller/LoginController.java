package Controller;

import javax.swing.JOptionPane;

import Model.UserModel;
import View.LoginView;
import View.RegisterView;

public class LoginController {
	 private UserModel userModel;
	    private LoginView loginView;

	    public LoginController(UserModel userModel, LoginView loginView) {
	        this.userModel = userModel;
	        this.loginView = loginView;
	    }

	    public void login(String username, String password) {
	        if (username.equals(userModel.getUsername()) && password.equals(userModel.getPassword())) {
	           //JOptionPane.showMessageDialog(loginView, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        	// JOptionPane.showMessageDialog(loginView, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        	 JOptionPane.showMessageDialog(loginView, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            loginView.showErrorMessage("Invalid username or password");
	        }
	    }

	    public void showRegisterWindow() {
	        RegisterController registerController = new RegisterController();
	        RegisterView registerView = new RegisterView(registerController);
	    }
	}

