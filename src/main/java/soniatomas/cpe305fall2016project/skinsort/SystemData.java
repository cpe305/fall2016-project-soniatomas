package main.java.soniatomas.cpe305fall2016project.skinsort;

public class SystemData {

  private static SystemData systemData;
  private User currentUser;
  private Product productOne;
  private Product productTwo;

  private SystemData() {
    currentUser = null;
    productOne = null;
    productTwo = null;
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
  
  public void setProductOne(Product productOne) {
    this.productOne = productOne;
  }
  
  public Product getProductOne() {
    return productOne;
  }
  public void setProductTwo(Product productTwo) {
    this.productTwo = productTwo;
  }
  
  public Product getProductTwo() {
    return productTwo;
  }

}
