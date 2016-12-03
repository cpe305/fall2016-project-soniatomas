package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.Observable;
import java.util.List;
import java.util.ArrayList;

public class ViewHistoryOperation extends Observable implements Operation  {
  private HashMap<String, Object> operationVariables;

  public ViewHistoryOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }
  
  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    User currentUser = SystemData.getInstance().getUser();
    List<Product> products = null;
    operationVariables.put("products", products);
    operationVariables.put("status", "FAILURE");
    if (currentUser != null) {
      operationVariables.put("products", currentUser.getProductHistory().getProductHistory());
      operationVariables.put("status", "SUCCESS");
    }
    return operationVariables;
  }
  
}
