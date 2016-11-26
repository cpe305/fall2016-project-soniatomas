package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;
import java.util.List;

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
  
  @Test
  public void TestAddReference() {
    Rating rating = new Rating();
    rating.addReference("Banana Boat Sunscreen");
    boolean referenceWasAdded = rating.containsReference("Banana Boat Sunscreen");
    assertTrue(referenceWasAdded);
  }
  
  @Test
  public void TestRemoveReferenceTrue() {
    Rating rating = new Rating();
    rating.addReference("Banana Boat Sunscreen");
    rating.removeReference("Banana Boat Sunscreen");
    boolean referenceExists = rating.containsReference("Banana Boat Sunscreen");
    assertTrue(!referenceExists);
  }
  
  @Test
  public void TestRemoveReferenceFalse() {
    Rating rating = new Rating();
    rating.addReference("Banana Boat Body Sunscreen");
    boolean removedReference = rating.removeReference("Banana Boat Face Sunscreen");
    assertTrue(!removedReference);
  }
  
  @Test
  public void TestGetReferences() {
    Rating rating = new Rating();
    rating.addReference("Banana Boat Face Sunscreen");
    rating.addReference("Banana Boat Body Sunscreen");
    List<String> references = rating.getReferences();
    assertEquals("Banana Boat Face Sunscreen", references.get(0));
    assertEquals("Banana Boat Body Sunscreen", references.get(1));
    
  }
  
  
  

}
