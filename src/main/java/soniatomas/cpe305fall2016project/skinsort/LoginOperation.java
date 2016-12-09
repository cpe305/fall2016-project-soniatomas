package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class LoginOperation extends Observable implements Operation {

  private HashMap<String, Object> operationVariables;

  public LoginOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }
  
  public String getStatus() {
    return (String)operationVariables.get("status");
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    operationVariables.put("status", "DATABASE_ERROR");
    if (!DatabaseManager.getInstance().errorInDatabase()) {
      String email = parameters.get("email");
      String password = parameters.get("password");
      operationVariables.put("status", "FAILURE");
      if (DatabaseManager.getInstance().queryUser(email, password)) {
        operationVariables.put("status", "SUCCESS");
      }
    }
    return operationVariables;
  }

}
