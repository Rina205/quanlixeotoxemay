package Test;

import Controller.LoginController;
import Model.UserModel;
import View.LoginView;

public class main {
	    public static void main(String[] args) {
	        UserModel userModel = new UserModel("phuong", "12345");
	        LoginView loginView = new LoginView(new LoginController(userModel, new LoginView(null)));
	    }
	}
