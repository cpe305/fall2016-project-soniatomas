package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.ArrayList;

public class ViewUserInfo {
  private ViewUserInfoView view;

  public ViewUserInfo(ViewUserInfoView view) {
    this.view = view;
  }

  public boolean execute(ArrayList<String> parameters) {
    String userInfo = "";
    User currentUser = SystemData.getInstance().getUser();
    if (currentUser != null) {
      userInfo += "First Name: " + currentUser.getFirstName() + "\n";
      userInfo += "Last Name: " + currentUser.getLastName() + "\n";
      userInfo += "Email: " + currentUser.getEmail() + "\n";
      view.setStatus(userInfo);
      return true;
    }
    return false;

  }
}
