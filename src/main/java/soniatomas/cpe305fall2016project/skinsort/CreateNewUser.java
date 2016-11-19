package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;

public class CreateNewUser implements Operation {
  public boolean execute(ArrayList<String> parameters) {
    if (!DatabaseManager.getInstance().errorInDatabase()) {
      String email = parameters.get(0);
      String password = parameters.get(1);
      String firstName = parameters.get(2);
      String lastName = parameters.get(3);

      User newUser = new User(email, password, firstName, lastName);
      if (DatabaseManager.getInstance().saveNewUserToDatabase(newUser))
        return true;
      else
        return false;
    }
    return false;
  }
}
