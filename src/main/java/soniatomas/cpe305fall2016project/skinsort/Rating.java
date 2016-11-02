package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.*;

public class Rating {
  private int userRating;
  private int systemRating;
  private ArrayList<String> references;
  
  public Rating()
  {
    references = new ArrayList<String>();
    userRating = 0;
    systemRating = 0;
  }
  public void setUserRating(int newRating)
  {
    this.userRating = newRating;
  }
  public void setSystemRating(int newRating)
  {
    this.systemRating = newRating;
  }
  public int getUserRating()
  {
    return userRating;
  }
  public int getSystemRating()
  {
    return systemRating;
  }
  public void addReference(String reference)
  {
    references.add(reference.toLowerCase());
  }
  public boolean removeRefence(String reference)
  {
    return references.remove(reference.toLowerCase());
  }

}
