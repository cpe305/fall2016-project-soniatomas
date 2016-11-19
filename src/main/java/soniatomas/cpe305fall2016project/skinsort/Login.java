package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;

public class Login implements Operation {

  private LoginView loginView;

  public Login(LoginView loginView) {
    this.loginView = loginView;
  }

  public boolean execute(ArrayList<String> parameters) {
    if (!DatabaseManager.getInstance().errorInDatabase()) {
      String email = parameters.get(0);
      String password = parameters.get(1);
      if (DatabaseManager.getInstance().queryUser(email, password)) {
        loginView.setStatus("");
        return true;
      }
      loginView.setStatus("Error: Incorrect Email/Password");
      return false;
    }
    loginView.setStatus("Error: Not connected to Database. Unable to Login.");
    return false;
  }

}
