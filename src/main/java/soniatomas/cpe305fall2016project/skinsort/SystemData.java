package main.java.soniatomas.cpe305fall2016project.skinsort;

public class SystemData {

  private static SystemData systemData;
  private User currentUser;

  private SystemData() {
    currentUser = null;
  }

  public static SystemData getInstance() {
    if (systemData == null) {
      systemData = new SystemData();
    }
    return systemData;
  }

  public void setUser(User user) {
    this.currentUser = user;
  }

  public User getUser() {
    return currentUser;
  }

}
