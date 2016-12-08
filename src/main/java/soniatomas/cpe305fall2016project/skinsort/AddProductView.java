package main.java.soniatomas.cpe305fall2016project.skinsort;


import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class AddProductView extends View implements Observer {
  private CreateNewUserOperation newUserOperation;
  private boolean status;
  private Scanner input;

  public AddProductView(Scanner scanner) {
    this.newUserOperation = new CreateNewUserOperation();
    newUserOperation.addObserver(this);
    this.input = scanner;
    this.status = false;
  }
  
  public void update(Observable obs, Object obj) {
    
  }

  public void display() {
    String category = null;
    String type = null;
    String brand = null;
    String name = null;
    String user_rating = null;
    String ingredients = null;
    
//    do {
//      System.out.println();
//      System.out.println("\nADD PRODUCT");
//      System.out.print("Category: ");
//      if (input.hasNext()) {
//        firstName = input.next().trim();
//      }
//      System.out.print("Type: ");
//      if (input.hasNext()) {
//        lastName = input.next().trim();
//      }
//      System.out.print(": ");
//      if (input.hasNext()) {
//        email = input.next().trim();
//      }
//      System.out.print("Password: ");
//      if (input.hasNext()) {
//        password = input.next().trim();
//      }
//      HashMap<String, String> parameters = new HashMap<String, String>();
//      parameters.put("email", email);
//      parameters.put("password", password);
//      parameters.put("first_name", firstName);
//      parameters.put("last_name", lastName);
//      newUserOperation.execute(parameters);
//      String status = (String)newUserOperation.getVariables().get("status");
//      if (status.equals("FAILURE"))
//      {
//        System.out.println("Error: There is an account associted with the inputted email.");
//        System.out.println("Unable to create new user.");
//        this.status = false;
//      }
//      else if (status.equals("DATABASE_ERROR")) {
//        System.out.println("Error connecting to the database. Unable to create new user.");
//        this.status = false;
//      }
//      else this.status = true;
//    } while (!status);
  }
}
