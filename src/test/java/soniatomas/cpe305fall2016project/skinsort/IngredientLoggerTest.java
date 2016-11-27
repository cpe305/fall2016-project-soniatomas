package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;
import main.java.soniatomas.cpe305fall2016project.skinsort.IngredientLogger;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;


public class IngredientLoggerTest {

  @Test
  public void TestAddIngredient() {
    IngredientLogger ingredientLogger = new IngredientLogger();
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    ingredientLogger.addIngredient(ingredientOne);
    ingredientLogger.addIngredient(ingredientTwo);
    ingredientLogger.addIngredient(new Ingredient("Propanediol"));
    ingredientLogger.addIngredient(new Ingredient("Sodium Stearate"));
    
    assertEquals(true, ingredientLogger.containsIngredient(ingredientOne));
    assertEquals(true, ingredientLogger.containsIngredient(ingredientTwo));
    assertEquals(true, ingredientLogger.containsIngredient("propanediol"));
    assertEquals(true, ingredientLogger.containsIngredient("sodium stearate"));  
  }
  
  @Test
  public void TestRemoveIngredient() {
    IngredientLogger ingredientLogger = new IngredientLogger();
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    ingredientLogger.addIngredient(ingredientOne);
    ingredientLogger.addIngredient(ingredientTwo);
    ingredientLogger.addIngredient(new Ingredient("Propanediol"));
    ingredientLogger.addIngredient(new Ingredient("Sodium Stearate"));
    
    assertEquals(true, ingredientLogger.removeIngredient(ingredientOne));
    assertEquals(true, ingredientLogger.removeIngredient(ingredientTwo));
    assertEquals(true, ingredientLogger.removeIngredient("propanediol"));
    assertEquals(true, ingredientLogger.removeIngredient("sodium stearate"));
    assertEquals(false, ingredientLogger.removeIngredient("sodium stearate"));
    assertEquals(false, ingredientLogger.removeIngredient(new Ingredient("water")));
  }
  
  @Test
  public void TestGetIngredient() {
    IngredientLogger ingredientLogger = new IngredientLogger();
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    ingredientLogger.addIngredient(ingredientOne);
    ingredientLogger.addIngredient(ingredientTwo);
    ingredientLogger.addIngredient(new Ingredient("Propanediol"));
    ingredientLogger.addIngredient(new Ingredient("Sodium Stearate"));
    
    Ingredient retrieveIngredient = ingredientLogger.getIngredient("aloe barbadensis leaf juice");
    retrieveIngredient.getRating().setSystemRating(7.9);
    retrieveIngredient.getRating().setUserRating(8.8);
    
    Ingredient retrievedIngredientAgain = ingredientLogger.getIngredient("aloe barbadensis leaf juice");
    assertEquals(8.8, retrievedIngredientAgain.getRating().getUserRating(), 0.00);
    assertEquals(7.9, retrievedIngredientAgain.getRating().getSystemRating(), 0.00);
    
  }

}
