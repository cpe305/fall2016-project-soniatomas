package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;

public class ViewHistoryView implements View {
  private Scanner input;
  private ViewHistory viewHistory;
  private String status;
  
  public ViewHistoryView(Scanner scan) {
    this.input = scan;
    viewHistory = new ViewHistory(this);
    status = "";
  }
  public void display() {
    String userFirstName = SystemData.getInstance().getUser().getFirstName();
    String userLastName = SystemData.getInstance().getUser().getLastName();
    System.out.println();
    System.out.println("VIEW HISTORY\n");
    System.out.println("Account User: " + userFirstName + " " + userLastName + "\n");
    viewHistory.execute(null);
    System.out.println(status);
    System.out.println();
    int command = 0;
    do {
      System.out.println("1) Go to Home Screen");
      System.out.print("option: " );
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
