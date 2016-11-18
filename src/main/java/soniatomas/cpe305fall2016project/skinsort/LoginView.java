package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class LoginView implements View {
  private Login login;
  private String status;
  private Scanner input;
  
  public LoginView(Scanner scanner)
  {
      this.login = new Login(this);
      this.input = scanner;
      status = "";
  }
  public void display() {
    boolean loginSuccessful = false;
    String email = null;
    String password = null;
    do {
      System.out.println();
      System.out.println("\nLOGIN");
      System.out.print("Email: ");
      if (input.hasNext())
       email = input.nextLine().trim();
      System.out.print("Password: ");
      if (input.hasNext())
       password = input.nextLine().trim();
      ArrayList<String> parameters = new ArrayList<String>();
      parameters.add(email);
      parameters.add(password);
      loginSuccessful = login.execute(parameters);
      System.out.println(status);
    } while(!loginSuccessful);
  }
  public void setStatus(String newStatus) {
    this.status = newStatus;
  }
}
