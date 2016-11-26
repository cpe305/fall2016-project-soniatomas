package test.java.soniatomas.cpe305fall2016project.skinsort;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.soniatomas.cpe305fall2016project.skinsort.Product;
import main.java.soniatomas.cpe305fall2016project.skinsort.Ingredient;
import main.java.soniatomas.cpe305fall2016project.skinsort.Rating;
import java.util.ArrayList;
public class ProductTest {

  @Test
  public void TestConstruct() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    assertEquals("skin care", productOne.getCategory());
    assertEquals("deoderant", productOne.getType());
    assertEquals("lavanilla", productOne.getBrand());
    assertEquals("the healthy deoderant - vanilla coconut", productOne.getName());
  }
  
  @Test
  public void TestEmtpyConstructor() {
    Product productTwo = new Product();
    productTwo.setCatergory("Skin Care");
    productTwo.setType("Moisturizer");
    productTwo.setBrand("First Aid Beauty");
    productTwo.setName("Ultra Repair Cream Intense Therapy");
    productTwo.setPrice(30.00);
    //new Product("Skin Care", "Moisturizer", "First Aid Beauty", "Ultra Repair Cream Intense Therapy");
    assertEquals("skin care", productTwo.getCategory());
    assertEquals("moisturizer", productTwo.getType());
    assertEquals("first aid beauty", productTwo.getBrand());
    assertEquals("ultra repair cream intense therapy", productTwo.getName());
    assertEquals(30.00, productTwo.getPrice(), 0.00);
  }
  
  @Test 
  public void TestGetRating() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Rating rating = productOne.getRating();
    assertEquals(0.0, rating.getSystemRating(), 0);
    assertEquals(0.0, rating.getUserRating(), 0);
  }

  @Test
  public void TestAddIngredient() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    productOne.addIngredient(ingredientOne);
    productOne.addIngredient(ingredientTwo);
    productOne.addIngredient("Propanediol");
    productOne.addIngredient("Sodium Stearate");
    
    assertTrue(productOne.containsIngredient(ingredientOne));
    assertTrue(productOne.containsIngredient(ingredientTwo));
    assertTrue(productOne.containsIngredient("propanediol"));
    assertTrue(productOne.containsIngredient("sodium stearate"));
  }
  
  @Test
  public void TestSetIngredients() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    ingredientList.add(ingredientOne);
    ingredientList.add(ingredientTwo);
    ingredientList.add(new Ingredient("Propanediol"));
    ingredientList.add(new Ingredient("Sodium Stearate"));
    
    productOne.setIngredients(ingredientList);
    
    assertTrue(productOne.containsIngredient(ingredientOne));
    assertTrue(productOne.containsIngredient(ingredientTwo));
    assertTrue(productOne.containsIngredient("propanediol"));
    assertTrue(productOne.containsIngredient("sodium stearate"));
  }
  
  @Test
  public void TestContainsIngredientFalse() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Ingredient ingredientOne = new Ingredient("Aloe Barbadensis Leaf Juice");
    Ingredient ingredientTwo = new Ingredient("Zea Mays (Corn) Starch");
    productOne.addIngredient(ingredientOne);
    productOne.addIngredient(ingredientTwo);
    productOne.addIngredient("Propanediol");
    productOne.addIngredient("Sodium Stearate");
    
    assertTrue(!productOne.containsIngredient("water"));
    assertTrue(!productOne.containsIngredient(new Ingredient("argan oil")));
  }
  
  @Test 
  public void TestSetRating() {
    Product productOne = new Product("Skin Care", "Deoderant", "lavanilla", "The Healthy Deoderant - Vanilla Coconut");
    Rating rating = new Rating();
    rating.setSystemRating(4.4);
    rating.setUserRating(7.9);
    productOne.setRating(rating);
    assertEquals(4.4, productOne.getRating().getSystemRating(), 0);
    assertEquals(7.9, productOne.getRating().getUserRating(), 0);
  }
}
