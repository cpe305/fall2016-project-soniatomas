package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.*;

/**
 * Class that handles creating hashes for passwords
 * @author Sonia
 *
 */
public class PasswordHandler {
  private static PasswordHandler passwordHandler = new PasswordHandler( );
  private static String salt;
  
  private PasswordHandler()
  { 
    salt = new String("skinsort");
  }
  public static PasswordHandler getInstance()
  {
    return passwordHandler;
  }
  
  public static String getPasswordHash(String password)
  {
    
    return null;
  }
  public static void setSalt(String salt)
  {
    salt = new String(salt);
  }

}
