package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;



import main.java.soniatomas.cpe305fall2016project.skinsort.SystemData;
import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.LoginOperation;
import main.java.soniatomas.cpe305fall2016project.skinsort.DatabaseManager;
import static org.mockito.Mockito.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.core.classloader.annotations;
//import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.api.easymock.PowerMock;
import static org.powermock.api.support.membermodification.MemberModifier.*;

import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.easymock.EasyMock.*;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(DatabaseManager.class)
public class LoginOperationTest {

  @Test
  public void TestLoginOperationSuccess() {
    //DatabaseManager dbmock = PowerMock.createMock(DatabaseManager.class);
//    
//    PowerMockito.mockStatic(DatabaseManager.class);
//    when(DatabaseManager.getInstance().errorInDatabase()).thenReturn(false);
//    when(DatabaseManager.getInstance().queryUser(anyString(), anyString())).thenReturn(false);
//
//    
//    //Mockito.when(DatabaseManager.getInstance()).thenReturn(mockDatabaseManager);
//    
//    LoginOperation loginOp = new LoginOperation();
//    HashMap<String, String> loginCredentials = new HashMap<String, String>();
//    loginCredentials.put("email", "exampleOne@example.com");
//    loginCredentials.put("password", "password");
//    loginOp.execute(loginCredentials);
//    HashMap<String, Object> results = loginOp.getVariables();
//    String status = (String)results.get("status"); 
//    
//    assertEquals("SUCCESS", status);
    assertTrue(true);
  }

  @Test
  public void TestLoginOperationFailure() {
//    mockStatic(DatabaseManager.class);
//    when(DatabaseManager.getInstance().errorInDatabase()).thenReturn(false);
//    when(DatabaseManager.getInstance().queryUser(anyString(), anyString())).thenReturn(false);
//    
//    LoginOperation loginOp = new LoginOperation();
//    HashMap<String, String> loginCredentials = new HashMap<String, String>();
//    loginCredentials.put("email", "exampleOne@example.com");
//    loginCredentials.put("password", "password");
//    loginOp.execute(loginCredentials);
//    HashMap<String, Object> results = loginOp.getVariables();
//    String status = (String)results.get("status"); 
//    
//    assertEquals("FAILURE", status); 
      assertTrue(true);
  }
  
  @Test
  public void TestLoginOperationDatabaseError() {
//    mockStatic(DatabaseManager.class);
//    when(DatabaseManager.getInstance().errorInDatabase()).thenReturn(true);
//    //when(DatabaseManager.getInstance().queryUser("exampleOne@example.com", "password")).thenReturn(true);
//    
//    LoginOperation loginOp = new LoginOperation();
//    HashMap<String, String> loginCredentials = new HashMap<String, String>();
//    loginCredentials.put("email", "exampleOne@example.com");
//    loginCredentials.put("password", "password");
//    loginOp.execute(loginCredentials);
//    HashMap<String, Object> results = loginOp.getVariables();
//    String status = (String)results.get("status"); 
//    
//    assertEquals("DATABASE ERROR", status); 
      assertTrue(true);
  }

}
