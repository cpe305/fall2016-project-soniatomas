package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;

public class ApplicationMain {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HomeView homeView = null;
    // System.out.println("Skin Sort");
    // System.out.println("Please enter the number of task you would like to
    // do");
    // System.out.println("1) Login");
    // //System.out.println("2) Create New Account");
    // System.out.println("3) Close Application");
    int command = 0;
    do {
      System.out.println("Skin Sort");
      System.out.println("Please enter the number of task you would like to do");
      System.out.println("1) Login");
      // System.out.println("2) Create New Account");
      System.out.println("3) Close Application");
      System.out.print("Option: ");
      if (input.hasNextInt())
        command = input.nextInt();
      else
        input.next();

      switch (command) {
      case 1:
        LoginView loginView = new LoginView(input);
        loginView.display();
        homeView = new HomeView(input);
        homeView.display();
        break;
      // case 2:
      // CreateNewAccountView createAccountView = new AccountView(input);
      // createAccountView.display();
      // System.out.print("Create new user account");
      // break;
      case 3:
        System.exit(0);
        break;
      default:
        System.out.println("Invalid Option");
      }

    } while (command != 3);
    // HomeView homeView = new HomeView(input);
    // homeView.display();
    // System.out.println("GoodBye!!!");
  }

}
