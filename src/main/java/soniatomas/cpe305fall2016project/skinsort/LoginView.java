package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class LoginView extends View implements Observer {
  private LoginOperation loginOperation;
  private boolean complete_status;
  private Scanner input;

  public LoginView(Scanner scanner) {
    this.loginOperation = new LoginOperation();
    loginOperation.addObserver(this);
    this.input = scanner;
    this.complete_status = false;
  }
  
  public void update(Observable obs, Object obj) {
    String status = (String)loginOperation.getVariables().get("status");
    if (status.equals("FAILURE"))
    {
      System.out.println("Invalid email/password");
      this.complete_status = false;
    }
    else if (status.equals("DATABASE_ERROR")) {
      System.out.println("Error connecting to the database. Unable to perform Login");
      this.complete_status = false;
    }
    else this.complete_status = true;
  }

  public void display() {
    String email = null;
    String password = null;
    do {
      System.out.println();
      System.out.println("\nLOGIN");
      System.out.print("Email: ");
      if (input.hasNextLine()) {
        email = input.nextLine().trim();
      }
      System.out.print("Password: ");
      if (input.hasNextLine()) {
        password = input.nextLine().trim();
      }
      HashMap<String, String> parameters = new HashMap<String, String>();
      parameters.put("email", email);
      parameters.put("password", password);
      loginOperation.execute(parameters);
    } while (!complete_status);
  }
}
