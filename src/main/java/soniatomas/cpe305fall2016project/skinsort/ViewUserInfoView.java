package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;

public class ViewUserInfoView implements View {
  private Scanner input;
  private ViewUserAccountOperation viewUserAccountOperation;
  private String status;

  public ViewUserInfoView(Scanner scan) {
    this.input = scan;
 //   viewUserAccountOperation = new ViewUserAccountOperation(this);
    status = "";
  }

  public void display() {
    String userFirstName = SystemData.getInstance().getUser().getFirstName();
    String userLastName = SystemData.getInstance().getUser().getLastName();
    System.out.println("\nVIEW USER INFO\n");
    System.out.println("Account User: " + userFirstName + " " + userLastName + "\n");
    //viewUserAccountOperation.execute(null);
    System.out.println(status);
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

  public void setStatus(String status) {
    this.status = status;
  }
}
