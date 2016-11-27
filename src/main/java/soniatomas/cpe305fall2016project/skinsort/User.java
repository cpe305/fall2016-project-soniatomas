package main.java.soniatomas.cpe305fall2016project.skinsort;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;

@Entity
public class User extends DatabaseEntity {

  private String firstName;
  private String lastName;
  private String password;
  private String email;
  @Embedded
  private ProductHistory productHistory;
  @Embedded
  private IngredientLogger ingredientLogger;

  public User(String email, String password, String firstName, String lastName) {
    this.productHistory = new ProductHistory();
    this.ingredientLogger = new IngredientLogger();
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }

  public User() {
    this.productHistory = new ProductHistory();
    this.ingredientLogger = new IngredientLogger();
    this.email = " ";
    this.firstName = " ";
    this.lastName = " ";
    this.password = " ";
  }

  /**
   * returns User's First Name
   * 
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set the firstName of User
   * 
   * @param username
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * return User's Last Name;
   * 
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set User's last name
   * 
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * set the User password Do not implement will rely on PasswordHandler which
   * has not been implemented
   * 
   * @param username
   */
  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isPasswordEqualTo(String password) {
    return this.password.equals(password);
  }

  /**
   * returns User's email
   * 
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   * set the User email
   * 
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public ProductHistory getProductHistory() {
    return this.productHistory;
  }
  
  public void setProductHistory(ProductHistory productHistory) {
    this.productHistory = productHistory;
  }

  public IngredientLogger getIngredientLogger() {
    return this.ingredientLogger;
  }
  
  public void setIngredientLogger(IngredientLogger newIngredientLogger) {
    this.ingredientLogger = newIngredientLogger;
    
  }
}
