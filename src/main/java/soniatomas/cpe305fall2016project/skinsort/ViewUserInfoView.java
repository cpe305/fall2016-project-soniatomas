package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;

public class ViewUserInfoView extends View {
  private Scanner input;
  private ViewUserAccountOperation viewUserAccountOp;

  public ViewUserInfoView(Scanner scan) {
    this.input = scan;
    viewUserAccountOp = new ViewUserAccountOperation();
  }

  public void display() {
    String userFirstName = SystemData.getInstance().getUser().getFirstName();
    String userLastName = SystemData.getInstance().getUser().getLastName();
    System.out.println("\nVIEW USER INFO\n");
    System.out.println("Account User: " + userFirstName + " " + userLastName + "\n");
    viewUserAccountOp.execute(null);
    User user = (User)viewUserAccountOp.getVariables().get("user");
    System.out.println();
    System.out.println("First Name: " + user.getFirstName());
    System.out.println("Last Name: " + user.getLastName());
    System.out.println("Email: " + user.getEmail());
    System.out.println();
    int command = 0;
    do {
      System.out.println("1) Go to Home Screen");
      System.out.print("option: ");
      if (input.hasNextInt())
        command = input.nextInt();
      else
        input.next();
    } while (command != 1);
  }
}
