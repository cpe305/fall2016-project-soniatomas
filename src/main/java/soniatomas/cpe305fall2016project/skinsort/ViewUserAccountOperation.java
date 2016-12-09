package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class ViewUserAccountOperation extends Observable implements Operation {

  private HashMap<String, Object> operationVariables;

  public ViewUserAccountOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  public String getStatus() {
    return (String)operationVariables.get("STATUS");
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    User currentUser = SystemData.getInstance().getUser();
    operationVariables.put("STATUS", "FAILURE");
    if (currentUser != null) {
      operationVariables.put("STATUS", "SUCCESS");
      operationVariables.put("FIRST_NAME", currentUser.getFirstName());
      operationVariables.put("LAST_NAME", currentUser.getLastName());
      operationVariables.put("EMAIL", currentUser.getEmail());
      operationVariables.put("USER", currentUser);
      
    }
    return operationVariables;

  }
}
