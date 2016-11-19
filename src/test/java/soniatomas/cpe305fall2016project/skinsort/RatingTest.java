package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;

public class RatingTest {

  @Test
  public void TestSetandGetSystemRating() {
    Rating rating = new Rating();
    rating.setSystemRating(4.4);
    assertEquals(4.4, rating.getSystemRating(), 0);
  }
  
  @Test
  public void TestSetandGetUserRating() {
    Rating rating = new Rating();
    rating.setUserRating(3.9);
    assertEquals(3.9, rating.getUserRating(), 0);
  }
  
  

}
