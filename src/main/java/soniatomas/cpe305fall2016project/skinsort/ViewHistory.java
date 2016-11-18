package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;

public class ViewHistory implements Operation {
  private ViewHistoryView view;
  
  public ViewHistory(ViewHistoryView view) {
    this.view = view;
  }
  
  public boolean execute(ArrayList<String> parameters) {
    String history = "";
    User currentUser = SystemData.getInstance().getUser();
    if (currentUser != null) {   
      for (Product product : currentUser.getProductHistory().getProductHistory()) {
        history += "Product name: " + product.getName() + "\t";
        history += product.getDateUpdated() + "\n\n";
       }
      view.setStatus(history);
      return true;
    }
    return false;
    
  }
}
