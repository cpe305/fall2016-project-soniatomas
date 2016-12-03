package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.Scanner;
import java.util.List;


public class ViewHistoryView extends View {
  private Scanner input;
  private boolean status;
  private ViewHistoryOperation viewHistoryOp;

  public ViewHistoryView(Scanner scan) {
    this.input = scan;
    viewHistoryOp = new ViewHistoryOperation();
    status = false;
  }

  public void display() {
    String userFirstName = SystemData.getInstance().getUser().getFirstName();
    String userLastName = SystemData.getInstance().getUser().getLastName();
    System.out.println();
    System.out.println("VIEW PRODUCT HISTORY\n");
    System.out.println("Account User: " + userFirstName + " " + userLastName + "\n");
    viewHistoryOp.execute(null);
    System.out.println();
    System.out.println("History");
    List<Product> products = (List<Product>)viewHistoryOp.getVariables().get("products");
    for(Product product : products) {
      System.out.println("Product name: " + product.getName() + "\t" + product.getDateUpdated() + "\n");
    }
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
