package main.java.soniatomas.cpe305fall2016project.skinsort;

public class SystemData {
  
  private static SystemData systemData;
  private User currentUser;
  private boolean errorInDatabase;
  
  private SystemData()
  {
    currentUser = null;
    errorInDatabase = false;
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
  
  public User getUser()
  {
    return currentUser;
  }
  
  public boolean errorInDatabase()
  {
    return errorInDatabase;
  }
  
  public void setErrorInDatabase(boolean value){
    errorInDatabase = value;
  }

}
