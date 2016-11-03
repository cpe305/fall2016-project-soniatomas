package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;

public class RatingTest {

  @Test
  public void UserRatingTest() {
    double userRating = 5.01;
    Rating rate = new Rating();
    rate.setUserRating(userRating);
    assertTrue(rate.getSystemRating() == 0);
    assertTrue(userRating == rate.getUserRating());
  }
  
  @Test
  public void SystemRatingTest() {
    double systemRating = 10.01;
    Rating rate = new Rating();
    rate.setSystemRating(systemRating);
    assertTrue(systemRating == rate.getSystemRating());
    assertFalse(systemRating == rate.getUserRating());
  }

  @Test
  public void ReferenceTest() {
    Rating rate = new Rating();
    rate.addReference("Jergen's Lotion");
    rate.addReference("BananaBoat Sunscreen");
    assertTrue(0 == rate.getSystemRating());
    assertTrue(0 == rate.getUserRating());
    assertFalse(rate.removeReference("Random thing"));
    assertTrue(rate.removeReference("Jergen's Lotion"));
  }

}
