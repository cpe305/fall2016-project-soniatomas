package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.User;
import main.java.soniatomas.cpe305fall2016project.skinsort.ProductHistory;
import main.java.soniatomas.cpe305fall2016project.skinsort.IngredientLogger;
import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;




public class UserTest {

  @Test
  public void TestEmptyConstructor() {
    //User user = new User("soniatomas@example.com", "password", "Sonia", "Tomas");
    User user = new User();
    user.setFirstName("Sonia");
    user.setLastName("Tomas");
    user.setEmail("soniatomas@example.com");
    user.setPassword("password");
    assertEquals("Sonia", user.getFirstName());
    assertEquals("Tomas", user.getLastName());
    assertEquals("soniatomas@example.com", user.getEmail());
    assertTrue(user.isPasswordEqualTo("password"));
    assertTrue(user.getProductHistory() != null);
    assertTrue(user.getIngredientLogger() != null);
  }

  @Test
  public void TestProductHistory() {
    User user = new User("soniatomas@example.com", "password", "Sonia", "Tomas");
    ProductHistory productHistory = user.getProductHistory();
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream");
    productTwo.setPrice(30.00);
    productHistory.addProduct(productOne);
    productHistory.addProduct(productTwo);
    user.setProductHistory(productHistory);
    Product productThree = new Product("Makeup", "Lipstick", "Nars", "Audacious Lipstick - Mona");
    productThree.setPrice(32.00);
    user.getProductHistory().addProduct(productThree);
    List<Product> productHistoryList = user.getProductHistory().getProductHistory();
    assertEquals(3, productHistoryList.size());
    assertTrue(user.getProductHistory().containsProduct("first aid beauty", "ultra repair cream"));
    assertTrue(user.getProductHistory().containsProduct("lavanilla", "the healthy deoderant - vanilla coconut"));
    assertTrue(user.getProductHistory().containsProduct("nars", "audacious lipstick - mona"));
    
  }
  
  @Test
  public void TestIngredientLogger() {
    User user = new User("soniatomas@example.com", "password", "Sonia", "Tomas");
    IngredientLogger ingredientLogger = user.getIngredientLogger();
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    ingredientLogger.addIngredient(ingredientOne);
    ingredientLogger.addIngredient(ingredientTwo);
    ingredientLogger.addIngredient(new Ingredient("Propanediol"));
    ingredientLogger.addIngredient(new Ingredient("Sodium Stearate"));
    Rating ratingOne = new Rating();
    ratingOne.setSystemRating(0.0);
    ratingOne.setUserRating(7.7);
    Rating ratingTwo = new Rating();
    ratingTwo.setSystemRating(4.4);
    ratingTwo.setUserRating(5.7);
    Rating ratingThree = new Rating();
    ratingThree.setSystemRating(3.3);
    ratingThree.setUserRating(2.2);
    Rating ratingFour = new Rating();
    ratingFour.setSystemRating(8.7);
    ratingFour.setUserRating(7.6);
    ingredientOne.setRating(ratingOne);
    ingredientTwo.setRating(ratingTwo);
    ingredientLogger.getIngredient("propanediol").setRating(ratingThree);
    ingredientLogger.getIngredient("sodium stearate").setRating(ratingFour);
    user.setIngredientLogger(ingredientLogger);
    assertEquals(7.7, user.getIngredientLogger().getIngredient("aloe barbadensis leaf juice").getRating().getUserRating(), 0.0);
    assertEquals(5.7, user.getIngredientLogger().getIngredient("zea mays (corn) starch").getRating().getUserRating(), 0.0);
    assertEquals(2.2, user.getIngredientLogger().getIngredient("propanediol").getRating().getUserRating(), 0.0);
    assertEquals(7.6, user.getIngredientLogger().getIngredient("sodium stearate").getRating().getUserRating(), 0.0);
    
    
  }
}
