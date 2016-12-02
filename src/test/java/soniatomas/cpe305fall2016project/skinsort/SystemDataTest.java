package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;
import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;

public class SystemDataTest {
  
  @Test
  public void TestSetAndGetUser() {
    User exampleUser = new User("exampleOne@example.com", "password", "James", "Blake");
    SystemData.getInstance().setUser(exampleUser);
    User retrievedUser = SystemData.getInstance().getUser();
    assertEquals("exampleOne@example.com", retrievedUser.getEmail());
    assertEquals("James", retrievedUser.getFirstName());
    assertEquals("Blake", retrievedUser.getLastName());
    assertTrue(retrievedUser.isPasswordEqualTo("password"));
    retrievedUser.setFirstName("Sonia");
    retrievedUser.setLastName("Tomas");
    retrievedUser.setEmail("soniatomas@example.com");
    retrievedUser.setPassword("newPassword");
    User retrievedUserAgain = SystemData.getInstance().getUser();
    assertEquals("Sonia", retrievedUserAgain.getFirstName());
    assertEquals("Tomas", retrievedUserAgain.getLastName());
    assertEquals("soniatomas@example.com", retrievedUserAgain.getEmail());
    assertTrue(retrievedUserAgain.isPasswordEqualTo("newPassword"));
  }
}
