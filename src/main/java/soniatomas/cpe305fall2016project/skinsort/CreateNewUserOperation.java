package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class CreateNewUserOperation extends Observable implements Operation {

  private HashMap<String, Object> operationVariables;

  public CreateNewUserOperation() {
    operationVariables = new HashMap<String, Object>();
  }
  
  public HashMap<String, Object> getVariables() {
    return operationVariables;
  }

  public HashMap<String, Object> execute(HashMap<String, String> parameters) {
    operationVariables.put("status", "FAILURE");
    operationVariables.put("status", "DATABASE ERROR");
    if (!DatabaseManager.getInstance().errorInDatabase()) {
      String email = parameters.get("email");
      String password = parameters.get("password");
      String firstName = parameters.get("firstName");
      String lastName = parameters.get("lastName");
      User newUser = new User(email, password, firstName, lastName);
      if (DatabaseManager.getInstance().saveNewUserToDatabase(newUser))
      {
        operationVariables.put("status", "SUCCESS");
      }
      else {
        operationVariables.put("status", "FAILURE");
      }
    }
    return operationVariables;
  }
}
