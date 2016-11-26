package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;

public class IngredientTest {

	@Test
	public void TestGetName() {
		Ingredient water = new Ingredient("water");
		assertEquals("water", water.getName());
	}
	
	@Test
	public void TestGetNameLowerCase() {
		Ingredient cocos_nucifera = new Ingredient("Cocos Nucifera");
		assertEquals("cocos nucifera", cocos_nucifera.getName());
		
	}
	
	@Test
	public void TestIsEqualToTrue() {
		Ingredient water = new Ingredient("water");
		assertEquals(true, water.isEqualTo(new Ingredient("water")));
	}
	
	@Test
	public void TestIsEqualToFalse() {
		Ingredient cocos_nucifera = new Ingredient("Cocos Nucifera");
		Ingredient water = new Ingredient("water");
		assertEquals(false, water.isEqualTo(cocos_nucifera));	
	}
	
	@Test 
	public void TestGetRating() {
	  Ingredient water = new Ingredient("Water");
	  Rating rating = water.getRating();
	  assertEquals(0.0, rating.getSystemRating(), 0);
    assertEquals(0.0, rating.getUserRating(), 0);
	}

	@Test 
  public void TestSetRating() {
    Ingredient water = new Ingredient("Water");
    Rating rating = new Rating();
    rating.setSystemRating(4.4);
    rating.setUserRating(7.9);
    water.setRating(rating);
    assertEquals(4.4, water.getRating().getSystemRating(), 0);
    assertEquals(7.9, water.getRating().getUserRating(), 0);
  }

	@Test 
  public void TestSetName() {
    Ingredient water = new Ingredient();
    water.setName("water");
    assertEquals("water", water.getName());
  }
	
	@Test 
  public void TestEquals() {
    Ingredient waterOne = new Ingredient();
    waterOne.setName("water");
    Ingredient waterTwo = new Ingredient("Water");
    assertEquals(true, waterOne.equals(waterTwo));
	}
	
}
