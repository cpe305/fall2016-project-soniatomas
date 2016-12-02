package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.*;

import static org.mockito.Mockito.*;
import java.util.HashMap;

public class ViewUserAccountOperationTest {

  @Test
  public void TestViewUserAccountInfoSuccess() {
    User user = new User("soniatomas@example.com", "password", "Sonia", "Tomas");
    SystemData.getInstance().setUser(user);
    ViewUserAccountOperation viewUserAccountOp = new ViewUserAccountOperation();
    viewUserAccountOp.execute(null);
    HashMap<String, Object> results = viewUserAccountOp.getVariables();
    String status = (String)results.get("status");
    User retrivedUser = (User)results.get("user");
    
    assertEquals("SUCCESS", status);
    assertEquals("soniatomas@example.com", retrivedUser.getEmail());
    assertEquals("Sonia", retrivedUser.getFirstName());
    assertEquals("Tomas", retrivedUser.getLastName());
    assertTrue(retrivedUser.isPasswordEqualTo("password"));
    
  }

  @Test
  public void TestViewUserAccountInfoFailure() {
    SystemData.getInstance().setUser(null);
    ViewUserAccountOperation viewUserAccountOp = new ViewUserAccountOperation();
    viewUserAccountOp.execute(null);
    HashMap<String, Object> results = viewUserAccountOp.getVariables();
    String status = (String)results.get("status");
    User retrievedUser = (User)results.get("user");
    
    assertEquals("FAILURE", status);
    assertTrue(retrievedUser == null);
    
  }
}
