package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;
import java.util.ArrayList;


public class HomeView implements View {
  private Scanner input;
  private String status;
  
  public HomeView(Scanner scan) {
    this.input = scan;
    this.status = "";
  }
  
  public void display() {
    boolean quit = false;
    int command = 0;
    do {
      String userFirstName = SystemData.getInstance().getUser().getFirstName();
      String userLastName = SystemData.getInstance().getUser().getLastName();
      System.out.println();
      System.out.println("HOME SCREEN");
      System.out.println("Account User: " + userFirstName + " " + userLastName);
      System.out.println("Please enter the number of the option you would like to do.");
      System.out.println("1) View Product History");
      System.out.println("2) View Account Information");
      System.out.println("3) Logout");
      System.out.println(status);
      System.out.print("option: " );
      if (input.hasNextInt())
          command = input.nextInt();
      else
          input.next();
      switch (command) {
      case 1 : 
        new ViewHistoryView(input).display();
        break;
      case 2:
        System.out.println("View Account Information");
        new ViewUserInfoView(input).display();
        break;
      case 3:
        quit = true;
        break;
      default:
        System.out.println("Error: Not a valid command!");
        break;
      }
    } while(!quit);
    //System.out.println("Goodbye");
  }
  public void setStatus(String newStatus) {
    this.status = newStatus;
  }
  

}