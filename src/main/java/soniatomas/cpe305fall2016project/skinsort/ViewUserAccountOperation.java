package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class ViewUserAccountOperation extends Observable implements Operation {

  private HashMap<String, Object> operationVariables;

  public ViewUserAccountOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    User currentUser = SystemData.getInstance().getUser();
    operationVariables.put("status", "FAILURE");
    if (currentUser != null) {
      operationVariables.put("status", "SUCCESS");
      operationVariables.put("user", currentUser);
    }
    return operationVariables;

  }
}
